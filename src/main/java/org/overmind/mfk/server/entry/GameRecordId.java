package org.overmind.mfk.server.entry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 30.05.2017 15:21
 */
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Embeddable
class GameRecordId implements Serializable {

    private Long gameId;

    private Byte place;
}
