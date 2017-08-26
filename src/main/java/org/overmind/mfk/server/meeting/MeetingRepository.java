package org.overmind.mfk.server.meeting;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:04
 */
public interface MeetingRepository extends Repository<Meeting, Long> {

    List<Meeting> findAll();

    Optional<Meeting> findOne(Long id);

    Meeting save(Meeting member);

}
