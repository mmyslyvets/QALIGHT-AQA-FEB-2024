package org.collections.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private final static String INSERT_FLIGHT =
            "INSERT INTO FlightData (CityName, FlightCost) VALUES ('%s', '%s')";

    private String cityName;
    private Long fligthCost;

    public String getFlightInsertSQL(){
        return String.format(INSERT_FLIGHT,
                this.getCityName(),
                this.getFligthCost());
    }
}
