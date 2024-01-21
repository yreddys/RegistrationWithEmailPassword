package com.Yarraneella.Hotel.service;

import com.Yarraneella.Hotel.entity.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	User registerUser(String username, String email, Long countryId, Long stateId, Long cityId);

	User loginUser(String email, String password, HttpSession httpSession);

	boolean passwordMatchesGenerated(User loggedInUser, String currentPassword);

	void changePassword(User loggedInUser, String newPassword);

}
