package com.Yarraneella.Hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yarraneella.Hotel.entity.Country;
import com.Yarraneella.Hotel.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {

		return countryRepository.findAll();
	}

}
