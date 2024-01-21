package com.Yarraneella.Hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yarraneella.Hotel.entity.Country;
import com.Yarraneella.Hotel.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> countries = countryService.getAllCountries();
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

}
