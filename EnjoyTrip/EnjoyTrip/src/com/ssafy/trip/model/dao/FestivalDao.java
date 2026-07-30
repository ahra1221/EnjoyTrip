package com.ssafy.trip.model.dao;

import java.util.List;

import com.ssafy.trip.model.dto.FestivalDto;
import com.ssafy.trip.model.dto.FestivalSearchDto;

public interface FestivalDao {
	
	public void loadData();
	
	public List<FestivalDto> searchByRegion(FestivalSearchDto festivalSearchDto);

	public List<FestivalDto> searchAll(FestivalSearchDto dto);
}
