package com.example.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.cardatabase.da.CarRepository;
import com.example.cardatabase.da.DriverRepository;
import com.example.cardatabase.da.OwnerRepository;
import com.example.cardatabase.da.TripRepository;
import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarOfDriver;
import com.example.cardatabase.domain.Driver;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.Trip;


@SpringBootApplication
public class CardatabaseApplication {

	@Autowired 
    private CarRepository carRepo;
	@Autowired 
    private OwnerRepository ownerRepo;
	@Autowired 
    private TripRepository tripRepo;
	@Autowired
	private DriverRepository driverRepo;

	
  private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CardatabaseApplication.class, args);

    logger.info("Hello Spring Boot");
  }
  @Bean
  CommandLineRunner runner(){
    return args -> {
    	
    	Owner o1 = new Owner("pini","Cohen");
    	Owner o2 = new Owner("Sergey","Aleynov");
    	ownerRepo.save(o1);
    	ownerRepo.save(o2);

    	
    	//Add trip objects
        Trip trip1 = new Trip("Tsafuna");
        Trip trip2 = new Trip("Daruma");
        tripRepo.save(trip1);
        tripRepo.save(trip2);
        
        // Add car object with link to owners and save these to db.
        
        Set<Trip> trips1= new HashSet<Trip>();
        trips1.add(trip1);
        trips1.add(trip2);
        
        Set<Trip> trips2= new HashSet<Trip>();
        trips2.add(trip1);
        
        Set<Trip> trips3= new HashSet<Trip>();
        trips3.add(trip2);
        
        Car car1 = new Car("Ford", "Mustang", "Red", 
                "ADF-1121", 2017, 59000,"dddd", o1,trips1);
        carRepo.save(car1);
        Car car2 = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2014, 29000,"dddd", o2,trips2);
        carRepo.save(car2);
        Car car3 = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2018, 39000,"dddd", o2, trips3);
        carRepo.save(car3);
            
            Set<CarOfDriver> set_cars_driver= new HashSet<CarOfDriver>();
      	  set_cars_driver.add(new CarOfDriver(car1, true));
      	  set_cars_driver.add(new CarOfDriver(car2, true));

      	  driverRepo.save(
      			  new Driver("Sara", set_cars_driver)
          		  );
    };
  } 
}
