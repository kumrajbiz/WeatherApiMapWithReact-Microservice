package com.java.net.entity;

/*
 * Author Rajesh kumar
 * */



public class Main {
	
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private int pressure;
    private int humidity;
    
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(Double feels_like) {
		this.feels_like = feels_like;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public Main(Double temp, Double feels_like, Double temp_min, Double temp_max, int pressure, int humidity) {
		super();
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
	}
	public Main() {
		super();
	}

}

