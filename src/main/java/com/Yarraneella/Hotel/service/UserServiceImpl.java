package com.Yarraneella.Hotel.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Yarraneella.Hotel.entity.User;
import com.Yarraneella.Hotel.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public User registerUser(String username, String email, Long countryId, Long stateId, Long cityId) {
		try {
			String generatedPassword = generateRandomPassword();
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setEmail(email);
			newUser.setPassword(generatedPassword);
			newUser.setGeneratedPassword(generatedPassword);
			newUser.setFirstLogin(true);
			userRepository.save(newUser);

			// Call the method to send the password email
			sendPasswordEmail(email, generatedPassword);

			return newUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User loginUser(String email, String password, HttpSession httpSession) {
		User loggedInUser = userRepository.findByEmail(email);
		if (loggedInUser != null && password.equals(loggedInUser.getPassword())) {
			httpSession.setAttribute("loggedInUser", loggedInUser);
			return loggedInUser;
		} else {
			return null;
		}
	}

	@Override
	public boolean passwordMatchesGenerated(User loggedInUser, String currentPassword) {
		return currentPassword.equals(loggedInUser.getGeneratedPassword());
	}

	@Override
	public void changePassword(User loggedInUser, String newPassword) {
		loggedInUser.setPassword(newPassword);
		loggedInUser.setFirstLogin(false);
		userRepository.save(loggedInUser);
	}

	private String generateRandomPassword() {
		int length = 6;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-+=";

		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(chars.length());
			password.append(chars.charAt(randomIndex));
		}

		return password.toString();
	}

	private void sendPasswordEmail(String email, String generatedPassword) {
	    try {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Your Password for first time login");
	        message.setText("Your password is: " + generatedPassword + "\n Please log in for password change\n\n Thanks!\n App team");

	        javaMailSender.send(message);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
