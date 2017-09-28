package org.overmind.mfk.server.repository;

import org.overmind.mfk.server.entry.MeetingEntry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:04
 */
public interface MeetingRepository extends Repository<MeetingEntry, Long> {

    MeetingEntry save(MeetingEntry member);

    Optional<MeetingEntry> findOne(Long id);

    List<MeetingEntry> findAll();

    @Query(nativeQuery = true, value = "SELECT *\n" +
        "FROM meetings m\n" +
        "WHERE date_part('year', m.date) = :#{#yearMonth.year} \n" +
        "      AND date_part('month', m.date) = :#{#yearMonth.monthValue}")
    Stream<MeetingEntry> findAllByYearMonth(@Param("yearMonth") YearMonth yearMonth); //TODO sort by date

    Stream<MeetingEntry> findByDateBetween(LocalDateTime from, LocalDateTime to, Sort sort);

}
