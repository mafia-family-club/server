package org.overmind.mfk.server.service;

import org.overmind.mfk.server.entry.MeetingEntry;
import org.overmind.mfk.server.exception.MeetingNotFoundException;
import org.overmind.mfk.server.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Stream;

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

    public MeetingEntry save(MeetingEntry meeting) {
        return repository.save(meeting);
    }

    public MeetingEntry findOne(Long id) throws MeetingNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new MeetingNotFoundException("MeetingEntry with id '" + id + "' not found")
            );
    }

    public List<MeetingEntry> findAll() {
        return repository.findAll();
    }

    public Stream<MeetingEntry> findAllByYearMonth(YearMonth yearMonth) {
        return repository.findAllByYearMonth(yearMonth);
    }
}
