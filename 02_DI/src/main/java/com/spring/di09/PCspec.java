package com.spring.di09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PCspec {
	private String cpu;
	private String mb;
	private String ram;
	private String ramsize;
	private String vga;
	private String ssd;
	private boolean hdd;
	private String psu;
}
