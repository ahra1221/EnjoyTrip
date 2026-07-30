package com.ssafy.trip.model.dao;

import java.util.List;

import com.ssafy.trip.model.dto.TripNearDto;

public interface TripNearDao {
	public  List<TripNearDto> searchAll();
}
