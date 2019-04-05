package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardCriteria;
import com.springbook.biz.board.BoardPageMaker;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public String dataTransform(BoardVO vo) {
		return "ㅎㅇㅎㅇ asdfasd";
	}
	/*public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardListVO;
	}*/
/*	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}*/
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
//		System.out.println("글 등록 처리");
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/Users/lkh/Documents/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
//		System.out.println("글 수정 처리");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
//		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
//		System.out.println("글 상세조회 처리");
		boardService.updateBoardCnt(vo);
		
		model.addAttribute("searchInfo", setSearchInfo(vo.getPage(), vo.getSearchCondition(), vo.getSearchKeyword()));
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	// 검색 조건 목록 설정 (당장 쓸일 없어 보이므로 주석 처리)
	/*@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}*/
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
//		System.out.println("글 목록 검색 처리");
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		System.out.println(vo.toString());
		// 페이징 목록
		BoardCriteria boardCriteria = new BoardCriteria(vo);
		
		if(vo.getPage() > 0) {
			boardCriteria.setPage(vo.getPage());
		}
		
		model.addAttribute("searchInfo", setSearchInfo(boardCriteria.getPage(), vo.getSearchCondition(), vo.getSearchKeyword()));
		model.addAttribute("boardList", boardService.getBoardList(boardCriteria));	// Model 정보 저장
		
		// 페이징 번호부분
		BoardPageMaker boardPageMaker = new BoardPageMaker();
		boardPageMaker.setBoardCriteria(boardCriteria);
		boardPageMaker.setTotalCount(boardService.getBoardListCount(vo));
		model.addAttribute("pageMaker", boardPageMaker);
		
		return "getBoardList.jsp";
	}
	
	// 검색 조건 및 페이지 설정
	public Map<String, String> setSearchInfo(int page, String condition, String keyword) {
		Map<String, String> searchInfo = new HashMap<String, String>();
		searchInfo.put("curPage", Integer.toString(page));
		searchInfo.put("searchCondition", condition);
		searchInfo.put("searchKeyword", keyword);
		
		return searchInfo;
	}
}
