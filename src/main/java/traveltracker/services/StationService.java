package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import traveltracker.entities.Interest;
import traveltracker.entities.Station;
import traveltracker.entities.User;
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
}
