package com.mybatis.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mybatis.model.Board;
import com.mybatis.model.BoardDAO;
import com.mybatis.model.Page;
import com.mybatis.model.ZzacherDAO;
import com.mybatis.model.ZzacherDTO;
import com.mybatis.service.Upload;

@Controller
public class BoardController {
	
	@Inject
	private BoardDAO dao;
	
	@Inject
	private Upload upload;
	
	@Inject
	private ZzacherDAO zao;
	
	//한 페이지에 보여줄 게시물 수
	private final int rowsize =3;
	
	//DB 상의 전체 게시물의 수
	private int totalRecord = 0;
	
	int page; //현재 페이지 변수
	
	@RequestMapping("board_list.go")
	public String list(HttpServletRequest request, Model model) {
		
		//페이징 처리 작업
		if(request.getParameter("page") != null) {
			page =Integer.parseInt(request.getParameter("page"));
		} else { //처음으로 게시물 전체 목록 태그를 클릭함
			page=1;
		}
		//DB 상의 전체 게시물 수를 확인하는 메서드
		totalRecord = this.dao.getListCount();
		
		Page pdto = new Page(page, rowsize, totalRecord);
		//현재 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<Board> list= this.dao.getBoardList(pdto);
		
		model.addAttribute("List", list);
		model.addAttribute("Paging", pdto);
		
		return "board_list";
	}
	@RequestMapping("board_write.go")
	public String write() {
		
		return "board_write";
		
	}
	@RequestMapping("board_write_ok.go")
	public void writeOk(
			@RequestParam("board_writer") String writer,
            @RequestParam("board_title") String title,
            @RequestParam("board_cont") String content,
            @RequestParam("board_pwd") String password,
            @RequestParam("img") MultipartFile file,
            HttpServletResponse response) {
		Board dto = new Board();
		dto.setBoard_writer(writer);
		dto.setBoard_title(title);
		dto.setBoard_cont(content);
		dto.setBoard_pwd(password);
		
		int board_no = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
		
			out.println("<script>");
			//ss
			if(board_no >0 && upload.fileUpload(file, dto.getBoard_no())) {
				out.println("alert('성공')");
				out.println("location.href='board_list.go'");
			} else {
				out.println("alert('실패')");
				out.println("history.back()");
			}
			out.println("</script>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("board_content.go")
	public String content(@RequestParam("no") int no, Model model) {
		
		this.dao.readCount(no);
		ZzacherDTO zto = this.zao.findByBoardNo(no);
		Board dto = this.dao.boardContent(no);
		
		model.addAttribute("cont", dto);
		model.addAttribute("pic", zto);
		
		return "board_content";
	}
	@RequestMapping("board_update.go")
	public String update(@RequestParam("no") int no, Model model) {
		
		this.dao.boardContent(page);
		
		Board dto = this.dao.boardContent(no);
		model.addAttribute("Upt", dto);
		
		return "board_update";
	}
	@RequestMapping("board_update_ok.go")
	public void updateOk(Board dto, HttpServletResponse res) throws IOException {
		int check = this.dao.updateBoard(dto);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		if(check >0) {
			out.println("alert('됨')");
			out.println("location.href='board_list.go'");
		} else {
			out.println("alert('안됨')");
			out.println("history.back()");
		}
		out.println("</script>");
	}
	@RequestMapping("board_delete.go")
	public String delete(@RequestParam("no") int no, Model model) {
		Board cont = this.dao.boardContent(no);
		
		model.addAttribute("delete", cont);
		return "board_delete";
	}
	@RequestMapping("board_delete_ok.go")
	public void deleteOk(Board dto, 
				@RequestParam("db_pwd") String db_pwd,
				HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		if(db_pwd.equals(dto.getBoard_pwd())) {
			int result = this.dao.deleteBoard(dto.getBoard_no());
			
			if(result >0) {
				this.dao.updateSeq(dto.getBoard_no());
				
				out.println("<script>");
				out.println("alert('됨')");
				out.println("location.href='board_list.go'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('안됨')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('되겠냐??')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	@RequestMapping("board_search.go")
	public String search(@RequestParam("field") String field,
						 @RequestParam("keyword") String keyword,
						 Model model, HttpServletRequest req) {
		//검색 페이징 처리 작업
		int page;			//현재 페이지 변수
		if(req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		} else { //검색 버튼을 클릭한 경우
			page =1;
		}
		//검색 분류와 검색어에 해당하는 게시글의 수를 DB에서 확인하는 작업.
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Field", field);
		map.put("Keyword", keyword);
		totalRecord = this.dao.searchBoardCount(map);
		Page pDto = new Page(page, rowsize, totalRecord, field, keyword);
		
		//검색 시 한 페이지당 보여줄 게시물 수만큼 검색한 게시물을 리스트로 가져오는 메서드
		List<Board> searchList = this.dao.searchBoardList(pDto);
		model.addAttribute("searchPageList", searchList).addAttribute("Paging", pDto);
		
		return "board_search_list";
				
	}
}
