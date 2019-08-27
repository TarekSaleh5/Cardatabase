package com.example.cardatabase.da;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cardatabase.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface CarRepository extends JpaRepository  <Car, Long> {

	 // Fetch cars by brand
	  List<Car> findByBrand(String brand);

	  // Fetch cars by color
	  List<Car> findByColor(String color);

	  // Fetch cars by year
	  List<Car> findByYear(int year);

	  List<Car> findByregisterNumber(int registerNumber);

	  // Fetch cars by brand and model
	  List<Car> findByBrandAndModel(String brand, String model);

	  // Fetch cars by brand or color
	  List<Car> findByBrandOrColor(String brand, String color); 
	  
	  // Fetch cars by brand and sort by year
	  List<Car> findByBrandOrderByYearAsc(String brand);
	  
	  // Fetch cars by brand using SQL
	  @Query("select c from Car c where c.brand = ?1")
	  List<Car> findByBrand2(String brand);
	  
	  @Query("select c from Car c where c.brand like %?1")
	  List<Car> findByBrandEndsWith(String brand);
	  
	  @Query(value = "SELECT * FROM CAR WHERE Car.brand = ?1", nativeQuery = true)
	  List<Car> findByBrand3(String brand);



	
}
