package com.flights.region.flighttickets.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flights.region.flighttickets.model.Flight;

public interface FlightsRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findByFlightid(String flightid);	
	List<Flight> findByFlightfrom(String flightfrom);
	List<Flight> findByFlightto(String flightto);
	List<Flight> findByDate(String fDate);
	List<Flight> findByRegion(String region);
	List<Flight> findByCarrier(String carrier);

	
}
