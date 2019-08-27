package com.example.appserver.carsapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long trip_id;
	
	String name;
	
	
	@ManyToMany(mappedBy = "trips")
	private Set<Car> cars;
	
	
	public Trip() {
		super();
	}
	
	
	
	
	
	public Trip(String name) {
		super();
		this.name = name;
		//this.cars=cars;
	}





	public Set<Car> getCars() {
		return cars;
	}





	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}





	public long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
