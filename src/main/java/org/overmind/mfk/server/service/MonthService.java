package org.overmind.mfk.server.service;

import org.overmind.mfk.server.model.MonthOfMeetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.09.2017 1:20
 */
@Service
public class MonthService {

    private final MeetingService meetingService;

    @Autowired
    public MonthService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    public MonthOfMeetings find(YearMonth yearMonth) {
        Assert.notNull(yearMonth, "'yearMonth' must be not null");

        final LocalDate today = LocalDate.now();

        return new MonthOfMeetings(
            yearMonth,
            yearMonth.atDay(1).getDayOfWeek(),
            yearMonth.lengthOfMonth(),
            yearMonth.equals(YearMonth.from(today)) ? today.getDayOfMonth() : null,
            meetingService.findAllByYearMonth(yearMonth)
        );

    }
}
