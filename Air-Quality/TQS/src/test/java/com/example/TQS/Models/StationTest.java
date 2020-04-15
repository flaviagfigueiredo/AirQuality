package com.example.TQS.Models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

public class StationTest {
    public static final String EXPECTED_NAME = "test";
    public static final String EXPECTED_TIMESTAMP = "timestamp";
    public static final Long EXPECTED_ID = Long.parseLong("1");
    public static final Long EXPECTED_AQI = Long.parseLong("1");
    public static final Double EXPECTED_PM25 = 0.0;
    public static final Double EXPECTED_PM10 = 0.0;
    public static final Double EXPECTED_O3 = 0.0;
    public static final Double EXPECTED_NO2 = 0.0;
    public static final Double EXPECTED_SO2 = 0.0;
    public static final Double EXPECTED_T = 0.0;
    public static final Double EXPECTED_H = 0.0;
    public static final Double EXPECTED_P = 0.0;
    public static final Double EXPECTED_W = 0.0;
    private static Station station;


    @BeforeAll
    public static void setUp() throws Exception {
        station = new Station(Long.parseLong("1"), "test", Long.parseLong("1"), "timestamp", 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0,  0.0, 0.0,  0.0);
    }

    @Test
    public void testStationDetails() throws Exception {
        assertThat(EXPECTED_NAME.equals(station.getName()));
        assertThat(EXPECTED_TIMESTAMP.equals(station.getTimestamp()));
        assertThat(EXPECTED_ID.equals(station.getId()));
        assertThat(EXPECTED_AQI.equals(station.getAqi()));
        assertThat(EXPECTED_PM25.equals(station.getPm25()));
        assertThat(EXPECTED_PM10.equals(station.getPm10()));
        assertThat(EXPECTED_O3.equals(station.getO3()));
        assertThat(EXPECTED_NO2.equals(station.getNo2()));
        assertThat(EXPECTED_SO2.equals(station.getSo2()));
        assertThat(EXPECTED_T.equals(station.getTemperature()));
        assertThat(EXPECTED_P.equals(station.getPressure()));
        assertThat(EXPECTED_H.equals(station.getHumidity()));
        assertThat(EXPECTED_W.equals(station.getWind()));

    }

}

