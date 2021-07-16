package ch.zli.m223.ksh18a.shotak.crm.control;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh18a.shotak.crm.service.GarageService;

@RestController()
@RequestMapping("rest/v1/garage")
public class GarageController {
	@Autowired
	private GarageService garageService;

	@GetMapping("")
	List<GarageDto> getAllGarage() {
		return garageService.getAllGarage().stream().map(garage -> new GarageDto(garage)).collect(Collectors.toList());
	}

	@PostMapping("")
	GarageDto insertGarage(@RequestBody GarageInputDto garageInput) {

		return new GarageDto(garageService.addGarage(garageInput.name, garageInput.ort));
	}
}
