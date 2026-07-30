package com.ssafy.trip.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.trip.model.dto.TripNearDto;

public class TripNearCSVParser {

	public List<TripNearDto> load() {

		List<TripNearDto> list = new ArrayList<>();
		String tripInfoFilePath = "res/소상공인상권정보서울데이터.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(tripInfoFilePath))) {

			br.readLine();

			String line;

			int num = 0;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				TripNearDto dto = new TripNearDto();

				dto.setNum(num++);
				dto.setTouristDestination(data[1].replace("\"", ""));
				dto.setTouristType(data[8].replace("\"", ""));
				dto.setStreetAddress(data[24].replace("\"", ""));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}
}