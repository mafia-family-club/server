package org.overmind.mfk.server.repository;

import org.overmind.mfk.server.entry.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:04
 */
public interface MeetingRepository extends Repository<Meeting, Long> {

    Meeting save(Meeting member);

    Optional<Meeting> findOne(Long id);

    List<Meeting> findAll();

    @Query(nativeQuery = true, value = "SELECT *\n" +
        "FROM meetings m\n" +
        "WHERE date_part('year', m.date) = :#{#yearMonth.year} \n" +
        "      AND date_part('month', m.date) = :#{#yearMonth.monthValue}")
    List<Meeting> findAllByYearMonth(@Param("yearMonth") YearMonth yearMonth);

}
