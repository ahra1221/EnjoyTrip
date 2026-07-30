package com.ssafy.trip.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.trip.model.dto.TripNearDto;
import com.ssafy.trip.model.service.TripNearService;
import com.ssafy.trip.model.service.TripNearServiceImpl;

public class TripNearView {

	private JFrame frame;

	private TripNearService tripNearService;

	private DefaultTableModel tripModel;
	private JTable tripTable;

	private String[] title = { "상호명", "업종분류명", "주소" };

	public TripNearView() {

		tripNearService = new TripNearServiceImpl();

		frame = new JFrame("주변 관광지 정보");

		setMain();

		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void setMain() {

		JLabel titleLabel = new JLabel("주변 관광지 정보", JLabel.CENTER);

		tripModel = new DefaultTableModel(title, 0);
		tripTable = new JTable(tripModel);

		JScrollPane scrollPane = new JScrollPane(tripTable);

		JPanel main = new JPanel(new BorderLayout());

		main.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		main.add(titleLabel, BorderLayout.NORTH);
		main.add(scrollPane, BorderLayout.CENTER);

		frame.add(main);

		showTrips();
	}

	private void showTrips() {

		List<TripNearDto> trips = tripNearService.searchAll();

		if (trips == null) {

			System.out.println("데이터 없음");

			return;
		}

		System.out.println("가져온 데이터 개수 : " + trips.size());

		// 서울 데이터만 저장
		String[][] data = new String[trips.size()][3];

		int i = 0;

		for (TripNearDto trip : trips) {
			if (!trip.getStreetAddress().contains("서울"))
				continue;

			data[i][0] = trip.getTouristDestination();

			data[i][1] = trip.getTouristType();

			data[i][2] = trip.getStreetAddress();

			i++;
		}

		String[][] result = new String[i][3];

		for (int j = 0; j < i; j++) {

			result[j][0] = data[j][0];
			result[j][1] = data[j][1];
			result[j][2] = data[j][2];

		}

		tripModel.setDataVector(result, title);

	}

}