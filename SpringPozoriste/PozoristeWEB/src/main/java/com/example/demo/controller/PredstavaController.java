package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import model.Predstava;
import model.Zanr;
import manager.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/predstave/")
public class PredstavaController {
	
	//Vezbe 3
	
	@GetMapping(value="getZanrovi")
	public String getZanrovi(HttpServletRequest request) {
		List<Zanr> zanrovi = Manager.sviZanrovi();
		request.getSession().setAttribute("zanrovi", zanrovi);
		return "predstaveZanr";
	}
	
	@GetMapping(value="getPredstave")
	public ModelAndView getPredstave(@RequestParam("zanr") String zanr) {
		List<Predstava> predstave = Manager.predstavePoZanru(Integer.parseInt(zanr));
		Map<Integer, String> predstaveMapa = new HashMap<Integer, String>();
		for(Predstava p : predstave) {
			predstaveMapa.put(p.getIdPredstava(), p.getNaziv());
		}
		ModelAndView model = new ModelAndView("predstaveZanr");
		model.addObject("predstaveMapa", predstaveMapa);
		return model;
	}
	
	@PostMapping(value="refreshPage")
	public String refreshPage(HttpServletRequest request) {
		return "predstaveZanr";
	}
		
	
}
