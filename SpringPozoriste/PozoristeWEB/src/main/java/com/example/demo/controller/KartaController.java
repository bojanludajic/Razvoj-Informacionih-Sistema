package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import manager.Manager;
import model.Karta;

@Controller
@RequestMapping("/karte/")
public class KartaController {

	@GetMapping(value="getKarte")
	public String getKarte(HttpServletRequest request) {
		List<Karta> karte = Manager.sveKarte();
		request.getSession().setAttribute("karte", karte);
		return "sveKarte";
	}
	
	@GetMapping(value="kartePoDatumu")
	public String kartePoDatumu(@RequestParam("datum") String datum, HttpServletRequest request) {
		List<Karta> filtriraneKarte = Manager.filtriraneKarte(datum);
		request.getSession().setAttribute("karte", filtriraneKarte);
		return "sveKarte";
	}
	
}

