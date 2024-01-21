package com.Yarraneella.Hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yarraneella.Hotel.entity.City;
import com.Yarraneella.Hotel.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

}
