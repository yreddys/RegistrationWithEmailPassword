package com.Yarraneella.Hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Yarraneella.Hotel.entity.User;
import com.Yarraneella.Hotel.model.ChangePasswordRequest;
import com.Yarraneella.Hotel.model.LoginRequest;
import com.Yarraneella.Hotel.model.RegistrationRequest;
import com.Yarraneella.Hotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody RegistrationRequest registrationRequest) {
		Long countryId = registrationRequest.getCountryId();
		Long stateId = registrationRequest.getStateId();
		Long cityId = registrationRequest.getCityId();

		// Validate the existence of country, state, and city entities

		User newUser = userService.registerUser(registrationRequest.getUsername(), registrationRequest.getEmail(),
				countryId, stateId, cityId);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest, HttpSession httpSession) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		User loggedInUser = userService.loginUser(email, password, httpSession);

		if (loggedInUser != null) {
			if (loggedInUser.isFirstLogin()) {
				// If it's the user's first login, return a specific message
				return new ResponseEntity<>("First login. Please change your password.", HttpStatus.OK);
			} else {
				// If it's not the first login, return a success message
				return new ResponseEntity<>("Login successful", HttpStatus.OK);
			}
		} else {
			// If login credentials are invalid, return an error message
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/change-password")
	public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest,
			HttpSession httpSession) {
		User loggedInUser = (User) httpSession.getAttribute("loggedInUser");

		if (loggedInUser != null && loggedInUser.isFirstLogin()) {
			// Check if the current password matches the generated one
			if (userService.passwordMatchesGenerated(loggedInUser, changePasswordRequest.getCurrentPassword())) {
				// Update the password and set firstLogin to false using the service layer
				userService.changePassword(loggedInUser, changePasswordRequest.getNewPassword());
				return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Invalid current password", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Invalid request", HttpStatus.UNAUTHORIZED);
		}
	}

}
