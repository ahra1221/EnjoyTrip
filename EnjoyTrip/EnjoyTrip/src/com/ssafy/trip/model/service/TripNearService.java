package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dto.TripNearDto;

public interface TripNearService {
	public List<TripNearDto> searchAll();
}
