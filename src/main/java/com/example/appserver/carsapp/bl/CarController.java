package com.example.appserver.carsapp.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appserver.carsapp.da.CarRepository;
import com.example.appserver.carsapp.domain.Car;

@RestController
public class CarController {

	
	@Autowired
    private CarRepository repository;

	
	 @RequestMapping("/cars")
     public Iterable<Car> getCars() {
		 
		 
		 List<Car> cars;
		 
		 //do some logic
		 
		 
		 //ask repository for cars
		 cars= repository.findAll();
		 
		 //do some logic
		 
		 return cars;

     } 

	
	
}
