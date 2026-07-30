package com.ssafy.trip.model.dto;

public class FestivalDto {
	private String sido;
	private String sigungu;
	private String place;
    public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

	private String festivalName;
    private String startDate="";
    private String endDate="";
    private String manager;

	public String getFestivalName() {
		return festivalName;
	}
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String y, String m, String d) {
		this.startDate = y+"."+m+"."+d;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String y, String m, String d) {
		this.endDate = y+"."+m+"."+d;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "FestivalSearchDto [sido=" + sido + ", sigungu=" + sigungu+ ", festivalname=" + festivalName+ ", startDate=" + startDate+", endDate=" + endDate+"]";
		
	}
	
}
