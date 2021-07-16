package ch.zli.m223.ksh18a.shotak.crm.service;

import java.util.List;

import ch.zli.m223.ksh18a.shotak.crm.model.AppUser;
import ch.zli.m223.ksh18a.shotak.crm.model.Bike;
import ch.zli.m223.ksh18a.shotak.crm.model.Garage;

public interface BikeService {

	List<Bike> getAllBikes();

	Bike addBike(String name, AppUser mieter, Garage garage);

}
