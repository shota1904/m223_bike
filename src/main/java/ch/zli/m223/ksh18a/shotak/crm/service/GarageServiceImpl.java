package ch.zli.m223.ksh18a.shotak.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.shotak.crm.exception.BikeAlreadyExistsException;
import ch.zli.m223.ksh18a.shotak.crm.exception.GarageNotFoundException;
import ch.zli.m223.ksh18a.shotak.crm.exception.InvalidArgumentException;
import ch.zli.m223.ksh18a.shotak.crm.model.Garage;
import ch.zli.m223.ksh18a.shotak.crm.repository.GarageRepository;

@Service
public class GarageServiceImpl implements GarageService {
	@Autowired
	GarageRepository repo;

	@Override
	public List<Garage> getAllGarage() {
		List<Garage> garage = new ArrayList<>();

		for (var gar : repo.findAll()) {
			garage.add(gar);
		}
		return garage;
	}

	@Override
	public Garage addGarage(String name, String ort) {
		if (name == null || ort == null) {
			throw new InvalidArgumentException();
		}
		if (repo.findByName(name).isPresent()) {
			throw new BikeAlreadyExistsException();
		}
		return repo.insertGarage(name, ort);
	}

	@Override
	public Garage findByName(String name) {
		if (name == null) {
			throw new InvalidArgumentException();
		}
		return repo.findByName(name).orElseThrow(GarageNotFoundException::new);
	}

	@Override
	public Garage getGarageById(long garageId) {
		return repo.findById(garageId).orElseThrow(GarageNotFoundException::new);
	}

}
