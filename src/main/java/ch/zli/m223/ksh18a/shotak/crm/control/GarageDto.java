package ch.zli.m223.ksh18a.shotak.crm.control;

import ch.zli.m223.ksh18a.shotak.crm.model.Garage;

public class GarageDto {
	public Long id;
	public final String name;
	public String ort;

	public GarageDto(Garage garage) {
		this.id = garage.getId();
		this.name = garage.getName();
		this.ort = garage.getOrt();
	}
}
