package com.ssafy.trip.model.dto;

public class FestivalSearchDto {
	/** 검색 조건 관광지명 */
	private String sido;
	private String sigungu;


	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getSido() {
		return sido;
	}
	
	public void setSido(String sido) {
		// TODO Auto-generated method stub
		this.sido = sido;
	}

	@Override
	public String toString() {
		return "FestivalSearchDto [sido=" + sido + ", sigungu=" + sigungu+"]";
	}

}
