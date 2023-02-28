package formula1.dto;

import lombok.Data;
@Data
public class BoardDto {
	private String userId;
	private int boardIdx;
	private String boardTitle;
	private String boardContents;
	private String boardWriter;
	private String boardCreatedDt;
	
}
