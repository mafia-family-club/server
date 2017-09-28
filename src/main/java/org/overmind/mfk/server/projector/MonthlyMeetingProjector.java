package org.overmind.mfk.server.projector;

import org.overmind.mfk.server.entry.MeetingEntry;
import org.overmind.mfk.server.model.MonthlyMeeting;
import org.springframework.stereotype.Service;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.09.2017 14:25
 */
@Service
public class MonthlyMeetingProjector {

    public MonthlyMeeting project(MeetingEntry meeting) {
        return new MonthlyMeeting(
            meeting.getId(),
            meeting.getTitle(),
            meeting.getDate().getDayOfMonth()
        );
    }
}
