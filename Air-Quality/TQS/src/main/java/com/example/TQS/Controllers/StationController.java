package com.example.TQS.Controllers;

import ch.qos.logback.classic.Logger;
import com.example.TQS.Models.Station;
import com.example.TQS.Models.StationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class StationController {
    @Autowired
    StationRepository stationRepository;

    private static int apiCount = 0;

    public static int getApiCount() {
        return apiCount;
    }

    public void incrementApiCount(){
        apiCount++;
    }

    // Get All Stations
    @GetMapping("/stations")
    public List<Station> all(){
        incrementApiCount();
        return stationRepository.findAll();
    }

    @PostMapping("/stations")
    Station addStation(@Valid @RequestBody Station station){
        return stationRepository.save(station);
    }


    @GetMapping("/station/{name}")
    public Station getCity(@PathVariable(value = "station") String station) throws JsonProcessingException{

        return getCityFromApi(station);
    }

    @GetMapping("/external_api/{station}")
    public Station getCityFromApi(@PathVariable(value = "station") String station) throws JsonProcessingException {
        final String uri = "https://api.waqi.info/feed/" + station + "" +
                "/?token=bbbe90f00de2a72658ac61515ad0038310930955" +
                "";



        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Muda o nome destas 2
        HashMap info = mapper.readValue(result, HashMap.class);
        HashMap data = (HashMap) info.get("data");

        // Continuar a ir buscar info para criar a Station

        Integer v_aqi = (Integer) (data.get("aqi"));
        Long aqi = Long.valueOf(v_aqi);
        Integer v_idx = (Integer) (data.get("idx"));
        Long idx = Long.valueOf(v_idx);

        ArrayList attributions = (ArrayList) data.get("attributions");

        HashMap city = (HashMap) data.get("city");
        String city_name = (String) city.get("name");

        HashMap iaqi = (HashMap) data.get("iaqi");
        HashMap h = (HashMap) iaqi.get("h");
        HashMap no2 = (HashMap) iaqi.get("no2");
        HashMap o3 = (HashMap) iaqi.get("o3");
        HashMap p = (HashMap) iaqi.get("p");
        HashMap pm10 = (HashMap) iaqi.get("pm10");
        HashMap pm25 = (HashMap) iaqi.get("pm25");
        HashMap so2 = (HashMap) iaqi.get("so2");
        HashMap t = (HashMap) iaqi.get("t");
        HashMap w = (HashMap) iaqi.get("w");

        Double h_value = (h != null) ? Double.parseDouble(h.get("v").toString()) : 0.0;
        Double no2_value = (no2 != null) ? Double.parseDouble(no2.get("v").toString()) : 0.0;
        Double o3_value =  (o3 != null) ? Double.parseDouble(o3.get("v").toString()) : 0.0;
        Double p_value  = (p != null) ?  Double.parseDouble(p.get("v").toString()) : 0.0;
        Double pm10_value = (pm10 != null) ? Double.parseDouble(pm10.get("v").toString()) : 0.0;
        Double pm25_value = (pm25 != null) ? Double.parseDouble(pm25.get("v").toString()) : 0.0;
        Double so2_value = (so2 != null) ? Double.parseDouble(so2.get("v").toString()) : 0.0;
        Double t_value = (t != null) ? Double.parseDouble(t.get("v").toString()) : 0.0;
        Double w_value = (w != null) ? Double.parseDouble(w.get("v").toString()) : 0.0;

        HashMap time = (HashMap) data.get("time");
        String timestamp = (String) time.get("s");



        Station newstation = new Station(idx, city_name, aqi, timestamp, pm25_value,
                pm10_value, o3_value, no2_value, so2_value,
                t_value,  h_value, p_value,  w_value);

        stationRepository.save(newstation);
        return newstation;
    }
}