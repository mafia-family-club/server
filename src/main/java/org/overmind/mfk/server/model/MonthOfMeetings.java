package org.overmind.mfk.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 27.08.2017 2:43
 */
@Value
public class MonthOfMeetings {

    @NonNull
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth month;

    @NonNull
    private DayOfWeek firstDayOfWeek;

    private int daysCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer currentDay;

    @NonNull
    private List<MonthlyMeeting> meetings;

}
