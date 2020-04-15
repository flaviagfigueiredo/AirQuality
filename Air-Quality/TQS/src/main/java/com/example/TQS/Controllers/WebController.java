package com.example.TQS.Controllers;

import com.example.TQS.Models.Station;
import com.example.TQS.Models.StationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class WebController {
    @Autowired
    StationRepository stationRepository;

    @Autowired
    StationController stationController;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String index(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("Lisbon");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/braga")
    String braga(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("Braga");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lisboa")
    String lisbon(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("Lisbon");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/barcelona")
    String barcelona(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("barcelona");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/faro")
    String faro(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("Faro");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/madrid")
    String madrid(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("madrid");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paris")
    String paris(Model model) throws JsonProcessingException {
        Station station = stationController.getCity("paris");

        System.out.println("\tSTATION PASSADA AO CONTROLLER: " + station);
        model.addAttribute("station", station);
        stationController.incrementApiCount();
        return "index";
    }


}