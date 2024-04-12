package com.spring.di09;

import java.util.ArrayList;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PCspec2 {
	private String cpu;
	private String mb;
	private ArrayList<String> ram;
	private String vga;
	private ArrayList<String> ssd;
	private Boolean hdd;
	private String psu;
	private String hddModel;
	
	// HDD 존재 여부에 따라서 모델명을 설정하는 메서드
    public void setHddInfo(Boolean hdd, String hddModel) {
        this.hdd = hdd;
        if (hdd) {
            this.hddModel = hddModel;
        } else {
            this.hddModel = ""; // HDD가 없으면 빈 문자열로 초기화
        }
    }
	
}
