package com.ssafy.trip.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

import com.ssafy.trip.model.dto.FestivalDto;
import com.ssafy.trip.model.dto.FestivalSearchDto;

public class FestivalDaoImpl implements FestivalDao{
	private List<FestivalDto> festivalList = new ArrayList<>();


	public FestivalDaoImpl() {
		loadData();
	}
	
	/**
	 * 관광지 정보를 csv파일에서 읽어온다.
	 */
	
	private String[] parseCSV(String line) {

	    List<String> result = new ArrayList<>();
	    StringBuilder sb = new StringBuilder();

	    boolean inQuotes = false;

	    for (int i = 0; i < line.length(); i++) {

	        char ch = line.charAt(i);

	        if (ch == '"') {
	            inQuotes = !inQuotes;
	        }
	        else if (ch == ',' && !inQuotes) {
	            result.add(sb.toString().trim());
	            sb.setLength(0);
	        }
	        else {
	            sb.append(ch);
	        }
	    }

	    // 마지막 컬럼 추가
	    result.add(sb.toString().trim());

	    return result.toArray(new String[0]);
	}
	
	
	@Override
	public void loadData() {
	    festivalList = new ArrayList<>();
	    try (BufferedReader br =
	            new BufferedReader(
	                new FileReader("res/2026지역축제데이터.csv"))) {

	        // 헤더 9줄 제거
	        for(int i=0; i<10; i++) {
	            br.readLine();
	        }

	        String line;

	        while((line = br.readLine()) != null) {
	        	String[] data = parseCSV(line);
	            if(data.length < 16)
	                continue;
	            FestivalDto dto = new FestivalDto();
	            dto.setFestivalName(data[3]);
	            dto.setPlace(data[5]);
	            dto.setSido(data[7]);
	            dto.setSigungu(data[8]);
	            dto.setStartDate(data[10],data[11],data[12]);
	            dto.setEndDate(data[13],data[14],data[15]);

	            festivalList.add(dto);

	    	    //System.out.println(Arrays.toString(parseCSV(line)));
	        }


	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    
	}
	
	
	@Override
	public List<FestivalDto> searchByRegion(FestivalSearchDto dto) {
		List<FestivalDto> result = new ArrayList<>();

	    for(FestivalDto festival : festivalList){

	        if(dto.getSido() != null 
	            && festival.getSido().contains(dto.getSido())) {

	            result.add(festival);
	        }
	    }

	    return result;
	}

	@Override
	public List<FestivalDto> searchAll(FestivalSearchDto dto) {

	    List<FestivalDto> result = new ArrayList<>();

	    for (FestivalDto festival : festivalList) {

	        boolean match = true;

	        if (dto.getSido() != null) {
	            match &= festival.getSido().contains(dto.getSido());
	        }

	        if (dto.getSigungu() != null) {
	            match &= festival.getSigungu().contains(dto.getSigungu());
	        }

	        if (match) {
	            result.add(festival);
	        }
	    }

	    return result;
	}
}
