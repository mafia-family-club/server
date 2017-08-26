package org.overmind.mfk.server.meeting;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.overmind.mfk.server.location.Location;

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
public class Meeting {

    @Id
    @GeneratedValue
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
