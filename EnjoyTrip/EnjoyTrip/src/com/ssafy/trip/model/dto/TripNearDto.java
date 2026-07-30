package com.ssafy.trip.model.dto;

public class TripNearDto {
	private int num;
	private String touristDestination;
	private String streetAddress;
	private String touristType;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTouristDestination() {
		return touristDestination;
	}
	public void setTouristDestination(String touristDestination) {
		this.touristDestination = touristDestination;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getTouristType() {
		return touristType;
	}
	
	public void setTouristType(String touristType) {
		this.touristType = touristType;
	}
	
	@Override
	public String toString() {
		return "TripNearDto [num=" + num + ", touristDestination=" + touristDestination + ", streetAddress="
				+ streetAddress + ", touristType=" + touristType + "]";
	}
}
