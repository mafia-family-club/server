package org.overmind.mfk.server.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 19:40
 */
@Entity(name = "locations")
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Location {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(length = 63)
    private String name;

    @Embedded
    private Geolocation geolocation;

    @JsonProperty("default")
    @Column(unique = true)
    private Boolean byDefault;

}
