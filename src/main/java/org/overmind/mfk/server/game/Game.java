package org.overmind.mfk.server.game;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.overmind.mfk.server.meeting.Meeting;
import org.overmind.mfk.server.member.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 19:16
 */
@Data
@Entity(name = "games")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Game {

    @Id
    @GenericGenerator(
        name = "game_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "games_id_seq")
        }
    )
    @GeneratedValue(generator = "game_generator")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private GameResult result;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private GameType type;

    @ManyToOne
    private Member leading;

    @OneToMany(mappedBy = "game")
    private List<GameRecord> records;

    @Lob
    @Column
    private String description;

}
