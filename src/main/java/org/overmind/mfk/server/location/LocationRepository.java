package org.overmind.mfk.server.location;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 20:11
 */
public interface LocationRepository extends Repository<Location, Long> {

    List<Location> findAll();

    Optional<Location> findOne(Long id);

    @Query("SELECT l FROM locations l where l.byDefault = true")
    Optional<Location> findDefault();

    Location save(Location member);
}
