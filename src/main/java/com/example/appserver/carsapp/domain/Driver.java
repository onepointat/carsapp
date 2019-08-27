package com.example.appserver.carsapp.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long trip_id;
	
	private String name;
	
	
	
	 @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
	    private Set<CarOfDriver> carsOfDriver;
	
	
	 
	 
	 
	 public Driver() {
		super();
	}
	
	
	public Driver(String name, Set<CarOfDriver> carsOfDriver) {
		super();
		this.name = name;
		
		 for(CarOfDriver carOfDriver : carsOfDriver) 
			 {
			 carOfDriver.setDriver(this);
			 }
		 
	     this.carsOfDriver = carsOfDriver;
		
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public long getTrip_id() {
		return trip_id;
	}


	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}


	public Set<CarOfDriver> getCarsOfDriver() {
		return carsOfDriver;
	}


	public void setCarsOfDriver(Set<CarOfDriver> carsOfDriver) {
		this.carsOfDriver = carsOfDriver;
	}
	
	
	
}
