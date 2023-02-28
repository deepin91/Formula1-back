package formula1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;

import formula1.dto.BoardDto;
import formula1.dto.CircuitDto;
import formula1.dto.DriverDto;
import formula1.dto.GrandprixDto;
import formula1.dto.NewsDto;
import formula1.dto.TeamDto;
import formula1.service.FormulaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class Formula1Controller {

	@Autowired
	FormulaService formulaService;

	/* mainpage */
	@GetMapping("/api/mainpage")
	public ResponseEntity<Map<String, Object>> mainpageList() throws Exception {
		List<GrandprixDto> GrandprixList = formulaService.grandprixList();
		List<CircuitDto> CircuitList = formulaService.circuitList();
		List<TeamDto> TeamList = formulaService.teamList();
		List<DriverDto> DriverList = formulaService.driverList();
		List<NewsDto> NewsList = formulaService.newsList();
		Map<String, Object> main = new HashMap<>(); // js에서의 객체의 존재랄까
		main.put("GrandprixList", GrandprixList);
		main.put("CircuitList", CircuitList);
		main.put("TeamList", TeamList);
		main.put("DriverList", DriverList);
		main.put("NewsList", NewsList);
		if (main != null && main.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(main);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/* board 작성 */
	@PostMapping("/api/board/write")
	public ResponseEntity<String> insertBoard(@RequestBody BoardDto boardDto) throws Exception {
		try {
			formulaService.insertBoard(boardDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록오류");
		}
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 등록되었습니다.");
	}

	/* board 목록 */
	@GetMapping("/api/board")
	public ResponseEntity<List<BoardDto>> boardList() throws Exception {
		List<BoardDto> BoardList = formulaService.boardList();
		if (BoardList != null && BoardList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(BoardList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/* board 상세 */
	@GetMapping("/api/board/{boardIdx}")
	public ResponseEntity<BoardDto> boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		BoardDto boardDto = formulaService.boardDetail(boardIdx);
		if (boardDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(boardDto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* driver 목록 */
	@GetMapping("/api/driver")
	public ResponseEntity<List<DriverDto>> driverList() throws Exception {
		List<DriverDto> DriverList = formulaService.driverList();
		if (DriverList != null && DriverList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(DriverList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* driver 상세 */
	@GetMapping("api/driver/{driverName}")
	public ResponseEntity<DriverDto> driverDetail(@PathVariable("driverName")String driverName) throws Exception{
		DriverDto driverDto = formulaService.driverDetail(driverName);
		if(driverDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(driverDto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* team 상세 */
	@GetMapping("api/team/{teamName}")
	public ResponseEntity<TeamDto> teamDetail(@PathVariable("teamName")String teamName) throws Exception{
		TeamDto teamDto = formulaService.teamDetail(teamName);
		if(teamDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(teamDto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
		
	/* (관리자)드라이버 등록 쿼리는 써놨음 */
	/* (관리자)소식 등록  */
	
	
	/* grandprix 목록 */
	@GetMapping("/api/grandprixList")
	public ResponseEntity<List<GrandprixDto>> GrandprixList() throws Exception {
		List<GrandprixDto> GrandprixList = formulaService.grandprixList();
		if (GrandprixList != null && GrandprixList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(GrandprixList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* circuit 목록 */
	@GetMapping("/api/circuitList")
	public ResponseEntity<List<CircuitDto>> CircuitList() throws Exception {
		List<CircuitDto> CircuitList = formulaService.circuitList();
		if (CircuitList != null && CircuitList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(CircuitList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* team 목록 */
	@GetMapping("/api/teamList")
	public ResponseEntity<List<TeamDto>> TeamList() throws Exception {
		List<TeamDto> TeamList = formulaService.teamList();
		if (TeamList != null && TeamList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(TeamList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* news 목록 */
	@GetMapping("/api/newsList")
	public ResponseEntity<List<NewsDto>> NewsList() throws Exception {
		List<NewsDto> NewsList = formulaService.newsList();
		if (NewsList != null && NewsList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(NewsList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/* circuit 등록 페이지 */
	/* circuit 수정,삭제 페이지(상세) */
	
	/* news 등록 페이지 */
	/* news 수정,삭제 페이지(상세) */
	
	/* driver 등록 페이지 */
	/* driver 수정,삭제 페이지(상세) */
	
	/* team 등록 페이지 */
	/* team 수정,삭제 페이지(상세) */
	
	/* grandprix 등록 페이지 */
	/* grandprix 수정,삭제 페이지(상세) */
	
	
//	@PostMapping("/company/regist")
//	public String insertcompany(@RequestParam("file") MultipartFile file, CompanyDto companydto) throws Exception {
//		petHotelService.insertcompany(file, companydto);
//		return ("redirect:/company");
//	}
	
}

//@GetMapping("/api/board")
//public ResponseEntity<List<BoardDto>> openBoardList() throws Exception {
//	List<BoardDto> list = boardService.selectBoardList();
//	if (list != null && list.size() > 0) {
//		return ResponseEntity.status(HttpStatus.OK).body(list);
//	} else {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	}
//}

//	@PostMapping("/api/board/write")
//	public ResponseEntity<Map<String, Object>> insertBoard(
//			@RequestBody BoardDto boardDto, HttpServletRequest request) throws Exception {
//		
//		String jwtToken = null;
//		String subject = null;
//		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			jwtToken = authorizationHeader.substring(7);
//			subject = jwtTokenUtil.getSubjectFromToken(jwtToken);
//		} 
//		boardDto.setCreatedId(subject);

//		
//		int insertedCount = 0;
//		try {
//			insertedCount = boardService.insertBoard(boardDto);
//			if (insertedCount > 0) {
//				Map<String, Object> result = new HashMap<>();
//				result.put("message", "정상적으로 등록되었습니다.");
//				result.put("count", insertedCount);
//				result.put("boardIdx", boardDto.getBoardIdx());		
//				return ResponseEntity.status(HttpStatus.OK).body(result);
//			} else {
//				Map<String, Object> result = new HashMap<>();
//				result.put("message", "등록된 내용이 없습니다.");
//				result.put("count", insertedCount);
//				return ResponseEntity.status(HttpStatus.OK).body(result);
//			}
//		} catch (Exception e) {
//			Map<String, Object> result = new HashMap<>();
//			result.put("message", "등록 중 오류가 발생했습니다.");
//			result.put("count", insertedCount);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
//		}
//	}
