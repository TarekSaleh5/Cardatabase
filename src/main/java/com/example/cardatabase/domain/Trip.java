package com.example.cardatabase.domain;



	import java.util.Set;

	import javax.persistence.*;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Trip {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long trip_id;
	String name;
	 
	private Set<Car> cars;

	public Trip(String name, Set<Car> cars) {
		super();
		
		this.name = name;
		this.cars=cars;
	}

	public Trip(String name) {
		super();
		this.name = name;
		}
	public Trip() {}
	
	@ManyToMany(mappedBy = "trips")
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


