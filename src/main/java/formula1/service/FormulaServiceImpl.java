package formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formula1.dto.BoardDto;
import formula1.dto.CircuitDto;
import formula1.dto.DriverDto;
import formula1.dto.GrandprixDto;
import formula1.dto.NewsDto;
import formula1.dto.TeamDto;
import formula1.mapper.FormulaMapper;

@Service
public class FormulaServiceImpl implements FormulaService {
	
	@Autowired
	FormulaMapper formulaMapper;
	
	@Override
	public List<GrandprixDto> grandprixList() throws Exception {
		return formulaMapper.grandprixList();
	}

	@Override
	public List<CircuitDto> circuitList() throws Exception {
		return formulaMapper.circuitList();
	}

	@Override
	public List<TeamDto> teamList() throws Exception {
		return formulaMapper.teamList();
	}

	@Override
	public List<DriverDto> driverList() throws Exception {
		return formulaMapper.driverList();
	}

	@Override
	public List<NewsDto> newsList() throws Exception {
		return formulaMapper.newsList();
	}

	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {
		formulaMapper.insertBoard(boardDto);
		
	}

	@Override
	public List<BoardDto> boardList() throws Exception {
		return formulaMapper.boardList();
	}

	@Override
	public BoardDto boardDetail(int boardIdx) throws Exception {
		return formulaMapper.boardDetail(boardIdx);
	}

	@Override
	public DriverDto driverDetail(String driverName) throws Exception {
		return formulaMapper.driverDetail(driverName);
	}

	@Override
	public TeamDto teamDetail(String teamName) throws Exception {
		return formulaMapper.teamDetail(teamName);
	}

}
