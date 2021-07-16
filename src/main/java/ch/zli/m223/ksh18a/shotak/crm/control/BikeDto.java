package ch.zli.m223.ksh18a.shotak.crm.control;

import ch.zli.m223.ksh18a.shotak.crm.model.Bike;

public class BikeDto {
	public Long id;
	public final String name;
	public Integer kennzeichen;

	public BikeDto(Bike bike) {
		this.id = bike.getID();
		this.name = bike.getName();

	}
}
