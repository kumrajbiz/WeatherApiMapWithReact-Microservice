package com.java.net.entity;

/*
 * Author Rajesh kumar
 * */

public class Wind {
    private Double speed;
    private int deg;
    
    
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public int getDeg() {
		return deg;
	}
	public void setDeg(int deg) {
		this.deg = deg;
	}
	public Wind(Double speed, int deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}
	public Wind() {
		super();
	}
    
    
}

