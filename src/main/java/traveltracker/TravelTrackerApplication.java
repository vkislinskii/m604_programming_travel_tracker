package traveltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import traveltracker.entities.City;
import traveltracker.entities.User;
import traveltracker.repositories.*;

import java.time.LocalDate;

@SpringBootApplication
public class TravelTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelTrackerApplication.class, args);
		//testSaveUser();
	}

	/*public static void testSaveUser() {
		City city = new City();
		city.setCityName("Paris");
		city.setCountry("France");
		CityRepository.save(city);

		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setCurrentCity(city);
		user.setRegistrationDate(LocalDate.now());
		userRepository.save(user);

	}*/

}
