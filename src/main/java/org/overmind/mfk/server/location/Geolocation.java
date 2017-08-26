package org.overmind.mfk.server.location;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 31.05.2017 0:04
 */
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Embeddable
class Geolocation {

    @NonNull
    private String url;

    @NonNull
    private String address;

}
