package ch.zli.m223.ksh18a.shotak.crm.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "garage")
public class GarageImpl implements Garage {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String ort;

	@OneToMany(mappedBy = "garage", fetch = FetchType.EAGER)
	private List<BikeImpl> bikes;

	protected GarageImpl() {
	}

	public GarageImpl(Long id, String name, String ort) {
		this.id = id;
		this.name = name;
		this.ort = ort;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getOrt() {
		// TODO Auto-generated method stub
		return ort;
	}

	@Override
	public List<Bike> getBikes() {
		// TODO Auto-generated method stub
		return bikes.stream().collect(Collectors.toList());
	}

}
