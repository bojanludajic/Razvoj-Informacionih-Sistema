package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import manager.Manager;
import model.Glumac;
import model.Izvodjenje;

@Service
public class IzvodjenjeService {

	public List<Izvodjenje> getIzvodjenja(String nazivPredstave) {
		return Manager.izvodjenjaPoNazivu(nazivPredstave);
	}
	
	public List<Glumac> getGlumci(int idIzvodjenja) {
		return Manager.glumciUIzvodjenju(idIzvodjenja);
	}
	
}
