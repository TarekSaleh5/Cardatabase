package com.example.cardatabase.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardatabase.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
