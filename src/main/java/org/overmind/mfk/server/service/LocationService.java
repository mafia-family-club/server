package org.overmind.mfk.server.service;

import org.overmind.mfk.server.exception.LocationNotFoundException;
import org.overmind.mfk.server.entry.Location;
import org.overmind.mfk.server.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 20:11
 */
@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location findOne(Long id) throws LocationNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new LocationNotFoundException("Location with id '" + id + "' not found")
            );
    }

    public Location save(Location location) {
        return repository.save(location);
    }
}
