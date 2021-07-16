package ch.zli.m223.ksh18a.shotak.crm.service;

import java.util.List;

import ch.zli.m223.ksh18a.shotak.crm.model.Garage;

public interface GarageService {

	List<Garage> getAllGarage();

	Garage addGarage(String name, String ort);

	Garage findByName(String name);

	Garage getGarageById(long garageId);

}
