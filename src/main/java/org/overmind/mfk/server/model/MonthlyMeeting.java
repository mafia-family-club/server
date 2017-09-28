package org.overmind.mfk.server.model;

import lombok.NonNull;
import lombok.Value;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.09.2017 2:51
 */
@Value
public class MonthlyMeeting {

    @NonNull
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private Integer dayOfMonth;

}
