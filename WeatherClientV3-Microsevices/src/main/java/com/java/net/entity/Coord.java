package com.java.net.entity;

/*
 * Author Rajesh kumar
 * */


public class Coord {
    private Double lon;
    private Double lat;
    
    public Coord(Double lon, Double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Coord() {
		super();
	}

	
    
}

