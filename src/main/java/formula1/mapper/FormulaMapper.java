package formula1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import formula1.dto.BoardDto;
import formula1.dto.CircuitDto;
import formula1.dto.DriverDto;
import formula1.dto.GrandprixDto;
import formula1.dto.NewsDto;
import formula1.dto.TeamDto;

@Mapper
public interface FormulaMapper {

	List<GrandprixDto> grandprixList()throws Exception;
	List<CircuitDto> circuitList()throws Exception;
	List<TeamDto> teamList()throws Exception;
	List<DriverDto> driverList()throws Exception;
	List<NewsDto> newsList()throws Exception;
	void insertBoard(BoardDto boardDto)throws Exception;
	List<BoardDto> boardList()throws Exception;
	BoardDto boardDetail(int boardIdx)throws Exception;
	DriverDto driverDetail(String driverName)throws Exception;
	TeamDto teamDetail(String teamName)throws Exception;
	
	

}
