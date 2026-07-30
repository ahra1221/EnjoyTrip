package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dao.FestivalDao;
import com.ssafy.trip.model.dao.FestivalDaoImpl;
import com.ssafy.trip.model.dto.FestivalDto;
import com.ssafy.trip.model.dto.FestivalSearchDto;

public class FestivalServiceImpl implements FestivalService{
	
	private FestivalDao festivalDao;
	
	public FestivalServiceImpl() {
		festivalDao=new FestivalDaoImpl();
	}


	@Override
	public List<FestivalDto> searchByRegion(FestivalSearchDto festivalSearchDto) {
		// TODO Auto-generated method stub
		return null;
	}



    @Override
    public List<FestivalDto> searchAll(FestivalSearchDto dto) {
        return festivalDao.searchAll(dto);
    }
}
