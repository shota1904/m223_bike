package ch.zli.m223.ksh18a.shotak.crm.model;

import java.util.List;

public interface Garage {
	public Long getId();

	public String getName();

	public String getOrt();

	public List<Bike> getBikes();
}
