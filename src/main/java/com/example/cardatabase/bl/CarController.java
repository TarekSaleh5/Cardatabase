package com.example.cardatabase.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.da.CarRepository;
import com.example.cardatabase.domain.Car;

@RestController
public class CarController {
	
	@Autowired
    private CarRepository repository;

	@RequestMapping("/cars")
    public Iterable<Car> getCars() {
		
		List<Car> cars;
		//do some logic
		
		//ask repository for cars
		cars=repository.findAll();
		
		return cars;
		//do some logic
		
		
    } 
	
}
