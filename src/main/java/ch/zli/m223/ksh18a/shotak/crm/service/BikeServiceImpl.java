package ch.zli.m223.ksh18a.shotak.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh18a.shotak.crm.exception.BikeAlreadyExistsException;
import ch.zli.m223.ksh18a.shotak.crm.exception.InvalidArgumentException;
import ch.zli.m223.ksh18a.shotak.crm.model.AppUser;
import ch.zli.m223.ksh18a.shotak.crm.model.Bike;
import ch.zli.m223.ksh18a.shotak.crm.model.Garage;
import ch.zli.m223.ksh18a.shotak.crm.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	BikeRepository repo;

	@Override
	public List<Bike> getAllBikes() {
		List<Bike> bikes = new ArrayList<>();

		for (var bike : repo.findAll()) {
			bikes.add(bike);
		}
		return bikes;
	}

	@Override
	public Bike addBike(String name, AppUser mieter, Garage garage) {
		if (name == null) {
			throw new InvalidArgumentException();
		}
		if (repo.findByName(name).isPresent()) {
			throw new BikeAlreadyExistsException();
		}

		return repo.insertBike(name, mieter, garage);
	}

}
