package org.overmind.mfk.server.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.overmind.mfk.server.entry.Location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 19:03
 */
@Data
@Entity(name = "meetings")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MeetingEntry {

    @Id
    @GenericGenerator(
        name = "meeting_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "meetings_id_seq")
        }
    )
    @GeneratedValue(generator = "meeting_generator")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "date")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "title", length = 127)
    private String title;

    @Column(name = "description")
    private String description;

    //TODO link with games

    @ManyToOne
    private Location location;

}
