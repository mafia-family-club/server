package org.overmind.mfk.server.service;

import org.overmind.mfk.server.entry.MeetingEntry;
import org.overmind.mfk.server.model.MonthOfMeetings;
import org.overmind.mfk.server.projector.MonthlyMeetingProjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.09.2017 1:20
 */
@Service
public class MonthService {

    private final MeetingService meetingService;

    private final MonthlyMeetingProjector projector;

    @Autowired
    public MonthService(MeetingService meetingService, MonthlyMeetingProjector projector) {
        this.meetingService = meetingService;
        this.projector = projector;
    }

    @Transactional
    public MonthOfMeetings find(YearMonth yearMonth) {
        Assert.notNull(yearMonth, "'yearMonth' must be not null");

        final LocalDate today = LocalDate.now();

        try (Stream<MeetingEntry> stream = meetingService.findAllByYearMonth(yearMonth)) {
            return new MonthOfMeetings(
                yearMonth,
                yearMonth.atDay(1).getDayOfWeek(),
                yearMonth.lengthOfMonth(),
                yearMonth.equals(YearMonth.from(today)) ? today.getDayOfMonth() : null,
                stream
                    .map(projector::project)
                    .collect(Collectors.toList())
            );
        }
    }
}
