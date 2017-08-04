package org.overmind.mfk.server.game;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.overmind.mfk.server.member.Member;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 27.05.2017 23:05
 */
@Data
@Entity(name = "game_records")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class GameRecord {

    @EmbeddedId
    private GameRecordId id;

    @MapsId("gameId")
    @ManyToOne
    private Game game;

    @ManyToOne
    private Member member;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private GameRole role;

    private Points points;

}
