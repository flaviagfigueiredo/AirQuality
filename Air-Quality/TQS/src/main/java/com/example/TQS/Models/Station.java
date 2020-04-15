package com.example.TQS.Models;
import javax.persistence.*;

@Entity(name="station")
@Table(name="station")
public class Station {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = false)
    private Long idApi;
    @Column(nullable = false, unique = false)
    private String name;
    @Column(nullable = false, unique = false)
    private Long aqi;
    @Column(nullable = false, unique = false)
    private String timestamp;


    @Column(nullable = true, unique = false)
    private Double pm25;
    @Column(nullable = true, unique = false)
    private Double pm10;
    @Column(nullable = true, unique = false)
    private Double o3;
    @Column(nullable = true, unique = false)
    private Double no2;
    @Column(nullable = true, unique = false)
    private Double so2;

    @Column(nullable = true, unique = false)
    private Double temperature;
    @Column(nullable = true, unique = false)
    private Double humidity;
    @Column(nullable = true, unique = false)
    private Double pressure;
    @Column(nullable = true, unique = false)
    private Double wind;

    public Station(Long idApi, String name, Long aqi, String timestamp, Double pm25, Double pm10, Double o3, Double no2, Double so2, Double temperature, Double humidity, Double pressure, Double wind) {
        this.idApi = idApi;
        this.name = name;
        this.aqi = aqi;
        this.timestamp = timestamp;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.o3 = o3;
        this.no2 = no2;
        this.so2 = so2;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
    }

    public Station() {}

    public Long getId() {
        return id;
    }

    public Long getIdApi() {
        return idApi;
    }

    public String getName() {
        return name;
    }

    public Long getAqi() {
        return aqi;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Double getPm25() {
        return pm25;
    }

    public Double getPm10() {
        return pm10;
    }

    public Double getO3() {
        return o3;
    }

    public Double getNo2() {
        return no2;
    }

    public Double getSo2() {
        return so2;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getWind() {
        return wind;
    }
}