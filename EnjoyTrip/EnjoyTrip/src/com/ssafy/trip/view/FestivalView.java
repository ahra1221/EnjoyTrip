package com.ssafy.trip.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.trip.model.dto.FestivalDto;
import com.ssafy.trip.model.dto.FestivalSearchDto;
import com.ssafy.trip.model.service.FestivalService;
import com.ssafy.trip.model.service.FestivalServiceImpl;

public class FestivalView {

    /** main 화면 */
    private JFrame festivalFrame;

    /** model */
    private FestivalService festivalService;

    /** 조회 내용 표시할 table */
    private DefaultTableModel festivalModel;
    private JTable festivalTable;
    private JScrollPane festivalPan;
    private static FestivalView instance;

    private String[] title = {
            "축제명",
            "장소",
            "시작일",
            "종료일"
    };
    
    public static void show(FestivalSearchDto dto) {

        if(instance == null) {
            instance = new FestivalView(dto);
        }
        else {
            instance.showFestivals(dto);
            instance.festivalFrame.setVisible(true);
            instance.festivalFrame.toFront();
        }
    }
    
    private FestivalView(FestivalSearchDto dto) {

        festivalService = new FestivalServiceImpl();

        festivalFrame = new JFrame("축제 목록");

        festivalFrame.setSize(800, 500);
        festivalFrame.setLocationRelativeTo(null);
        festivalFrame.setResizable(true);

        setMain();

        showFestivals(dto);

        festivalFrame.setVisible(true);
    }

    private void setMain() {

        festivalModel = new DefaultTableModel(title, 0);
        festivalTable = new JTable(festivalModel);
        festivalPan = new JScrollPane(festivalTable);

        festivalFrame.add(festivalPan);
    }

    private void showFestivals(FestivalSearchDto dto) {

        List<FestivalDto> list = festivalService.searchAll(dto);

        if(list == null || list.isEmpty()) {

            String[][] data = {
                {"해당 지역에는 예정된 축제가 없습니다.", "", "", ""}
            };

            festivalModel.setDataVector(data, title);
            return;
        }


        String[][] data = new String[list.size()][4];

        int i = 0;

        for(FestivalDto festival : list){

            data[i][0] = festival.getFestivalName();
            data[i][1] = festival.getPlace();
            data[i][2] = festival.getStartDate();
            data[i][3] = festival.getEndDate();

            i++;
        }

        festivalModel.setDataVector(data, title);
    }
}