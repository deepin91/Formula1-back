package formula1.dto;

import lombok.Data;

@Data
public class GrandprixDto {
	private int circuitIdx;
	private int grandprixIdx;
	private String grandprixDate;
	private String grandprixWeather;
}
