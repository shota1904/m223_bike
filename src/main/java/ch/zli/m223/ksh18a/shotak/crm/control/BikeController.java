package ch.zli.m223.ksh18a.shotak.crm.control;

//hallo
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh18a.shotak.crm.model.AppUser;
import ch.zli.m223.ksh18a.shotak.crm.model.Garage;
import ch.zli.m223.ksh18a.shotak.crm.service.BikeService;
import ch.zli.m223.ksh18a.shotak.crm.service.GarageService;
import ch.zli.m223.ksh18a.shotak.crm.service.UserService;

@RestController()
@RequestMapping("rest/v1/bikes")
public class BikeController {

	@Autowired
	private BikeService bikeService;
	@Autowired
	private UserService userService;
	@Autowired
	private GarageService garageService;

	@GetMapping("")
	List<BikeDto> getAllbikes() {
		return bikeService.getAllBikes().stream().map(bike -> new BikeDto(bike)).collect(Collectors.toList());
	}

	@PostMapping("")
	BikeDto insertBike(@RequestBody BikeInputDto bikeInput) {
		AppUser mieter = userService.getUserById(bikeInput.mieterId);
		Garage garage = garageService.getGarageById(bikeInput.garageId);
		return new BikeDto(bikeService.addBike(bikeInput.name, mieter, garage));
	}
}
