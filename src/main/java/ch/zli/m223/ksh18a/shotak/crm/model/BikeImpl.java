package ch.zli.m223.ksh18a.shotak.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Bike")
public class BikeImpl implements Bike {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer kennzeichen;

	@ManyToOne(fetch = FetchType.EAGER)
	private AppUserImpl mieter;
	@ManyToOne(cascade = CascadeType.DETACH)
	private GarageImpl garage;

	protected BikeImpl() {
	}

	public BikeImpl(Long id, String name, AppUser mieter, Garage garage) {
		this.id = id;
		this.name = name;
		this.mieter = (AppUserImpl) mieter;
		this.garage = (GarageImpl) garage;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKennzeichen(Integer kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	@Override
	public Long getID() {
		return id;
	}

	@Override
	public AppUser getMieter() {
		return mieter;
	}

}
