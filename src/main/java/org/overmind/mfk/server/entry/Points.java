package org.overmind.mfk.server.entry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 27.05.2017 23:07
 */
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Embeddable
class Points {

    private BigDecimal basePoints;

    private BigDecimal bonusPoints;

    private BigDecimal totalPoints;

}
