package com.mybatis.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mybatis.model.ZzacherDAO;
import com.mybatis.model.ZzacherDTO;

@Service
public class Upload {
	
	@Inject
	private ZzacherDAO zdao;
	
	public boolean fileUpload(
			MultipartFile mFile,int board_no) throws IllegalStateException, IOException {
			boolean isUpload = false;
			String uploadPath = "C:\\Users\\goott3\\git\\goottSpring\\12_MyBatis_Board\\src\\main\\webapp\\resources\\upload\\";
			
			Calendar cal = Calendar.getInstance();
			
			int year = cal.get(Calendar.YEAR);
			
			int month = cal.get(Calendar.MONTH)+1;
			
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String uploadFileName = mFile.getOriginalFilename();
			
			System.out.println("uploadFileName: "+uploadFileName);
			
			//getOriginalFilename(): 업로드 되는 파일에서 확장자를 포함한 
									 //파일명을 반환해주는 메서드
			String originalFileName = mFile.getOriginalFilename();
			
			System.out.println("originalFileName: "+originalFileName);
			
			//실제로 폴더를 만들어보자
			//  .....\\resources\\upload\\2024-04-25
			String day1 = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
			String homedir = uploadPath + day1;

			File path1 = new File(homedir);
			System.out.println("경로: "+homedir);
			System.out.println();
			
			if(!path1.exists()) {
				path1.mkdir(); //실제로 폴더를 만들어주는 메서드
			} 
			//실제 파일을 만들어 보자
			String saveFileName = originalFileName;
			
			if(!saveFileName.equals("")) {
				saveFileName = UUID.randomUUID() + "_" +saveFileName;
				
				File origin = new File(homedir+"/"+saveFileName);
				//transferTo(): 파일 데이터를 지정한 폴더로 저장시키는 메서드
				mFile.transferTo(origin);
				
				ZzacherDTO dto = new ZzacherDTO();
				dto.setFile_name(saveFileName);
				dto.setFile_path(day1+"/"+saveFileName);
				dto.setBoard_no(board_no);
				this.zdao.addFile(dto);
				
				isUpload = true;
			}
			return isUpload;
	}
}
