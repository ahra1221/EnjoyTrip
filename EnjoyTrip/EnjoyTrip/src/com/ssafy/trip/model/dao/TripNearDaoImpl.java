package com.ssafy.trip.model.dao;

import java.util.List;

import com.ssafy.trip.model.dto.TripNearDto;
import com.ssafy.trip.util.TripNearCSVParser;

public class TripNearDaoImpl implements TripNearDao {

	private List<TripNearDto> trips;

	public TripNearDaoImpl() {
		TripNearCSVParser parser = new TripNearCSVParser();
		trips = parser.load();
	}

	@Override
	public List<TripNearDto> searchAll() {
		return trips;
	}

}