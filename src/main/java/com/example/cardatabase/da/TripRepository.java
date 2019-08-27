package com.example.cardatabase.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardatabase.domain.Trip;

public interface TripRepository extends JpaRepository  <Trip, Long> {
	

}
