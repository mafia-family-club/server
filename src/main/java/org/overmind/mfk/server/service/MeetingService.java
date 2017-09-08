package org.overmind.mfk.server.service;

import org.overmind.mfk.server.exception.MeetingNotFoundException;
import org.overmind.mfk.server.entry.Meeting;
import org.overmind.mfk.server.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
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

    public Meeting save(Meeting meeting) {
        return repository.save(meeting);
    }

    public Meeting findOne(Long id) throws MeetingNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new MeetingNotFoundException("Meeting with id '" + id + "' not found")
            );
    }

    public List<Meeting> findAll() {
        return repository.findAll();
    }

    public List<Meeting> findAllByYearMonth(YearMonth yearMonth) {
        return repository.findAllByYearMonth(yearMonth);
    }
}
