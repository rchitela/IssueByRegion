package com.region.us.issues.flighttickets.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.region.us.issues.flighttickets.Repository.FlightsRepository;
import com.region.us.issues.flighttickets.model.Flight;

@RestController
@RequestMapping("/api/flights")
public class FlightsService {

	private static final Logger logger = LoggerFactory.getLogger(FlightsService.class);
	
	private FlightsRepository flightsRepository;

	public FlightsService(FlightsRepository flightsRepository) {
		this.flightsRepository = flightsRepository;
	}
	
	@GetMapping("/fid/{flightid}")
	public List<Flight> getFlightsByFlightId(@PathVariable("flightid") final String flightid) {
		logger.info("flightid: " + flightid);
		return flightsRepository.findByFlightid(flightid).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/from/{flightfrom}")
	public List<Flight> getFlightsFrom(@PathVariable("flightfrom") final String flightfrom) {
		logger.info("flightfrom: " + flightfrom);
		return 	flightsRepository.findByFlightfrom(flightfrom).stream().collect(Collectors.toList());
	}	
	
	@GetMapping("/to/{flightto}")
	public List<Flight> getFlightsTo(@PathVariable("flightto") final String flightto) {
		logger.info("flightto: " + flightto);
		return 	flightsRepository.findByFlightto(flightto).stream().collect(Collectors.toList());
	}
	
	
	@GetMapping("/date/{date}")
	public List<Flight> getFlightsDate(@PathVariable("date") final String date) {
		logger.info("date: " + date);
		return 	flightsRepository.findByDate(date).stream().collect(Collectors.toList());
	}
	
	
	@GetMapping("/region/{region}")
	public List<Flight> getFlightsByRegion(@PathVariable("region") final String region) {
		logger.info("region: " + region);
		return 	flightsRepository.findByRegion(region).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/location/{location}")
	public List<Flight> getFlightsByLocation(@PathVariable("location") final String location) {
		logger.info("location: " + location);
		return 	flightsRepository.findByLocation(location).stream().collect(Collectors.toList());
	}
	
	@GetMapping("/carrier/{carrier}")
	public List<Flight> getFlightsByCarrier(@PathVariable("carrier") final String carrier) {
		logger.info("carrier: " + carrier);
		return 	flightsRepository.findByCarrier(carrier).stream().collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public List<Flight> add(@RequestBody final Flight flight){
		logger.info("Flight Id: " + flight.getFlightid());
		flightsRepository.save(flight);

		return getFlightsByFlightId(flight.getFlightid());
	}
	
	@GetMapping("/locations")
	public List<String> getLocations() {		
		List<Flight> flights =  flightsRepository.findAll();
		List<String> locations = new ArrayList<String>();
		for(Flight flight: flights) {
			locations.add(flight.getLocation());
		}		
		return locations;
	}
	
	@PostMapping("/delete/{flightid}")
	public List<Flight> delete(@PathVariable("flightid") final String flightid) {
		List<Flight> flights = flightsRepository.findByFlightid(flightid);
		for(Flight flight: flights)
			flightsRepository.delete(flight);		
		return getFlightsByFlightId(flightid);
	}
	
}
