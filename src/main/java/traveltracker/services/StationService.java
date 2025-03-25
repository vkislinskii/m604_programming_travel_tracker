package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.Station;
import traveltracker.repositories.StationRepository;

import java.util.List;

@Service
public class StationService {
    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations() {
        List<Station> stations = stationRepository.findAll();
        if (stations.isEmpty()) {
            throw new ResourceNotFoundException("No stations were found");
        }
        return stations;
    }

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public Station updateStation(String stationName, Station stationDetails) {
        Station existingStation = stationRepository.findById(stationName)
                .orElseThrow(() -> new ResourceNotFoundException("Station not found with name: " + stationName));

        existingStation.setCity(stationDetails.getCity());

        return stationRepository.save(existingStation);
    }

    @Transactional
    public void deleteStation(String stationName) {
        stationRepository.findById(stationName)
                .orElseThrow(() -> new ResourceNotFoundException("Station not found with name: " + stationName));
        stationRepository.deleteById(stationName);
    }
}
