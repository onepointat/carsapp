package com.example.appserver.carsapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Car {
	
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long id;
	
	  private String brand, model, color, registerNumber;
	  private int year, price;
	  
	  
	  @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "owner")
	  private Owner owner;

	
	  
	  @ManyToMany(cascade = CascadeType.MERGE)
	  @JoinTable(name = "car_in_trip", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "trip_id"))
 	 Set<Trip> trips;
	  
	  
	  
	  @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	    private Set<CarOfDriver> driversOfCar = new HashSet<>();
	  
	
  public Set<CarOfDriver> getDriversOfCar() {
		return driversOfCar;
	}

	public void setDriversOfCar(Set<CarOfDriver> driversOfCar) {
		this.driversOfCar = driversOfCar;
	}

public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}

public Car( String brand, String model, String color, String registerNumber, int year, int price, Owner owner, Set<Trip> trips) {
		//super();
		//this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		
		this.owner=owner;
		
		this.trips=trips;
		
	}

public Car() {}


  
public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}

public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}

