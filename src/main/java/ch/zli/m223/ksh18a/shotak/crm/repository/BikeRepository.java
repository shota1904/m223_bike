package ch.zli.m223.ksh18a.shotak.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.zli.m223.ksh18a.shotak.crm.model.AppUser;
import ch.zli.m223.ksh18a.shotak.crm.model.Bike;
import ch.zli.m223.ksh18a.shotak.crm.model.BikeImpl;
import ch.zli.m223.ksh18a.shotak.crm.model.Garage;

public interface BikeRepository extends CrudRepository<BikeImpl, Long> {

	default Bike insertBike(String name, AppUser mieter, Garage garage) {
		return save(new BikeImpl(null, name, mieter, garage));
	}

	@Query
	Optional<Bike> findByName(String name);
}
