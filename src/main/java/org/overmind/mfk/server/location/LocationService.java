package org.overmind.mfk.server.location;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 28.05.2017 20:11
 */
@Service
public class LocationService {

    private LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    List<Location> findAll() {
        return repository.findAll();
    }

    Location findOne(Long id) throws LocationNotFoundException {
        return repository.findOne(id)
            .orElseThrow(
                () -> new LocationNotFoundException("Location with id '" + id + "' not found")
            );
    }

    Location findDefault() throws LocationNotFoundException {
        return repository.findDefault()
            .orElseThrow(() -> new LocationNotFoundException("Default location doesn't exist"));
    }

    Location save(Location location) {
        return repository.save(location);
    }
}
