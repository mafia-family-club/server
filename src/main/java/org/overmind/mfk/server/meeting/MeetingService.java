package org.overmind.mfk.server.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:04
 */
@Service
public class MeetingService {

    private final MeetingRepository repository;

    @Autowired
    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }

    List<Meeting> findAll() {
        return repository.findAll();
    }

    Meeting findOne(Long id) throws MeetingNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new MeetingNotFoundException("Meeting with id '" + id + "' not found")
            );
    }

    Meeting save(Meeting meeting) {
        return repository.save(meeting);
    }
}
