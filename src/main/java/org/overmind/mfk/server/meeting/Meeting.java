package org.overmind.mfk.server.meeting;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDateTime;
import org.overmind.mfk.server.game.Game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;

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

    //TODO add type annotation
    private LocalDateTime date;

    @Column(length = 127)
    private String title;

    @Lob
    @Column
    private String description;

    @OneToMany(mappedBy = "meeting")
    private List<Game> games;

}
