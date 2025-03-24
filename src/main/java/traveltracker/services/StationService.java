package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Station;
import traveltracker.repositories.StationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    /*public Optional<Station> getStationsByCityId(Integer cityId) {
        return stationRepository.findByCity(cityId);        //.findBy(); //.findByCity(cityId); //City(cityId);
    }*/
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public Station updateStation(String stationName, Station stationDetails) {
        Station existingStation = stationRepository.findById(stationName)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + stationName));

        existingStation.setCity(stationDetails.getCity());

        return stationRepository.save(existingStation);
    }

    @Transactional
    public boolean deleteStation(String stationName) {
        if (stationRepository.existsById(stationName)) {
            stationRepository.deleteById(stationName);
            return true;
        }
        return false;
    }
}
