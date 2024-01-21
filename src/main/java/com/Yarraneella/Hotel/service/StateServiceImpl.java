package com.Yarraneella.Hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Yarraneella.Hotel.entity.State;
import com.Yarraneella.Hotel.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> getAllStates() {

		return stateRepository.findAll();
	}

}
