package com.region.us.issues.flighttickets.model;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flights", catalog="airlines")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="flightid")
	private String flightid;
	
	@Column(name="flightfrom")
	private String flightfrom;
	
	@Column(name="flightto")
	private String flightto;
	
	@Column(name="date")
	private String date;
	
	@Column(name="region")
	private String region;
	
	@Column(name="location")
	private String location;
	
	@Column(name="carrier")
	private String carrier;
	
	public Flight() {
	}

	public Flight(String flightid, String flightfrom, String flightto, String date, 
			String region, String location, String carrier) {
		this.flightid = flightid;
		this.flightfrom = flightfrom;
		this.flightto = flightto;
		this.date = date;
		this.region = region;
		this.location = location;
		this.carrier = carrier;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getFlightfrom() {
		return flightfrom;
	}

	public void setFlightfrom(String flightfrom) {
		this.flightfrom = flightfrom;
	}

	public String getFlightto() {
		return flightto;
	}

	public void setFlightto(String flightto) {
		this.flightto = flightto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightid=" + flightid + ", flightfrom=" + flightfrom + ", flightto=" + flightto
				+ ", date=" + date + ", region=" + region + ", location=" + location + ", carrier=" + carrier + "]";
	}

}
