package formula1.dto;

import lombok.Data;

@Data
public class NewsDto {
	private String userId;
	private int newsIdx;
	private String newsTitle;
	private String newsContents;
	private String newsWriter;
	private String newsCreatedDt;
	
}
