package org.overmind.mfk.server.location;

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

    Location save(Location member);
}
