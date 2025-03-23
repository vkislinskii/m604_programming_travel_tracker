package traveltracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import traveltracker.entities.*;
import traveltracker.repositories.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DatabaseTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testSaveUser() {
        City city = new City();
        city.setCityName("Paris");
        city.setCountry("France");
        cityRepository.save(city);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setCurrentCity(city);
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);

        Assertions.assertNotNull(user.getUserId());
    }
}
