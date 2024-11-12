package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Glumac;
import model.Izvodjenje;

@Controller
@RequestMapping("/izvodjenje/")
public class IzvodjenjeController {

	@Autowired
	IzvodjenjeService service;
	
	
	@GetMapping(value="getIzvodjenja")
	public String getIzvodjenja(@RequestParam("naziv") String nazivPredstave, Model model) {
		List<Izvodjenje> izvodjenja = service.getIzvodjenja(nazivPredstave);
		if(!izvodjenja.isEmpty()) {
			model.addAttribute("izvodjenja", izvodjenja);
		} else {
			model.addAttribute("poruka", "Nema izvodjenja za uneti naziv predstave");
		}
		
		return "pretragaIzvodjenja";
	}
	
	@GetMapping(value="getGlumci")
	public String getGlumci(@RequestParam("idIzvodjenja") Integer idIzvodjenja, Model model) {
		List<Glumac> glumci = service.getGlumci(idIzvodjenja);
		if(!glumci.isEmpty()) {
			model.addAttribute("glumci", glumci);
		} else {
			model.addAttribute("poruka", "Nema glumaca u datom izvodjenju");
		}
		return "glumciUIzvodjenju";
	}
	
}
