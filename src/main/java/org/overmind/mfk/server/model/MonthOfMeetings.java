package org.overmind.mfk.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;
import org.overmind.mfk.server.entry.Meeting;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 27.08.2017 2:43
 */
@Data
public class MonthOfMeetings {

    @NonNull
    @JsonFormat(pattern = "yyyy-MM")
    private final YearMonth month;

    @NonNull
    private final DayOfWeek firstDayOfWeek;

    @NonNull
    private final int daysCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer currentDay;

    @NonNull
    private final List<Meeting> meetings;

}
