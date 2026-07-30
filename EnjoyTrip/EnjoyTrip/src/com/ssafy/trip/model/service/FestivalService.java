package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dto.FestivalDto;
import com.ssafy.trip.model.dto.FestivalSearchDto;



public interface FestivalService {
	public List<FestivalDto>  searchAll(FestivalSearchDto tripSearchDto);

	List<FestivalDto> searchByRegion(FestivalSearchDto festivalSearchDto);
}
