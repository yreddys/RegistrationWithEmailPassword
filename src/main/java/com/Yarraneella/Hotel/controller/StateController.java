package com.Yarraneella.Hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yarraneella.Hotel.entity.State;
import com.Yarraneella.Hotel.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public ResponseEntity<List<State>> getAllStates() {
		List<State> states = stateService.getAllStates();
		return new ResponseEntity<>(states, HttpStatus.OK);
	}

}
