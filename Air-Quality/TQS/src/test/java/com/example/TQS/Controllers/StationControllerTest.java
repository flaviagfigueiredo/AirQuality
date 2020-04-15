package com.example.TQS.Controllers;

import com.example.TQS.Models.Station;
import com.example.TQS.Models.StationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StationControllerTest {

    @Mock
    private StationRepository stationRepositoty;

    @InjectMocks
    private StationController stationController;

    @Test
    void testFindAll() {
        //given
        Station station_1 = new Station(Long.parseLong("1"), "test1", Long.parseLong("1"), "timestamp", 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0,  0.0, 0.0,  0.0);

        Station station_2 = new Station(Long.parseLong("2"), "test1", Long.parseLong("2"), "timestamp", 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0,  0.0, 0.0,  0.0);


        Station station_3 = new Station(Long.parseLong("3"), "test1", Long.parseLong("3"), "timestamp", 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0,  0.0, 0.0,  0.0);

        List<Station> stations = new ArrayList<>();
        stations.add(station_1);
        stations.add(station_2);
        stations.add(station_3);

        when(stationController.all()).thenReturn(stations);

        //when
        List<Station> result = stationController.all();

        //then
        assertThat(result.size() == 3);
        assertThat(result.get(0) == station_1);
        assertThat(result.get(1) == station_2);
        assertThat(result.get(2) == station_3);
    }


    @Test
    void shouldReturnStation() throws JsonProcessingException {
        String station = "Lisbon";
        Station station_test = new Station(Long.parseLong("1"), station, Long.parseLong("1"), "timestamp", 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0,  0.0, 0.0,  0.0);

        Station result = stationController.getCityFromApi(station);

        assertThat(result == station_test);
    }
}