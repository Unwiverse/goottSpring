package com.mybatis.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.model.Board;
import com.mybatis.model.BoardDAO;
import com.mybatis.model.Page;

@Controller
public class BoardController {
	
	@Inject
	private BoardDAO dao;
	
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
	public void writeOk(Board dto, HttpServletResponse response) throws IOException {
		int check = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		if(check >0) {
			out.println("alert('성공')");
			out.println("location.href='board_list.go'");
		} else {
			out.println("alert('실패')");
			out.println("history.back()");
		}
		out.println("</script>");
	}
	@RequestMapping("board_content.go")
	public String content(@RequestParam("no") int no, Model model) {
		
		this.dao.readCount(no);
		Board dto = this.dao.boardContent(no);
		model.addAttribute("cont", dto);
		
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
		res.setContentType("html/text; charset=UTF-8");
		
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
}
