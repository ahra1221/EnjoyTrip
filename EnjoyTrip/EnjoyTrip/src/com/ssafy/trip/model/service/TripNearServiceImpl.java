package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dao.TripNearDao;
import com.ssafy.trip.model.dao.TripNearDaoImpl;
import com.ssafy.trip.model.dto.TripNearDto;

public class TripNearServiceImpl implements TripNearService {

	private TripNearDao dao;

	public TripNearServiceImpl() {
		dao = new TripNearDaoImpl();
	}

	@Override
	public List<TripNearDto> searchAll() {
		return dao.searchAll();
	}

}