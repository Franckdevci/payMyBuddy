package com.paymybuddyapp.paymybuddy.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.paymybuddyapp.paymybuddy.model.User;
import com.paymybuddyapp.paymybuddy.repository.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		System.out.println("UserRepository injected: " + userRepository);
	}

	public User saveUser(User user) {
		logger.info("1. Before saving user in UserService: {}", user);

		User savedUser = userRepository.save(user);

		logger.info("2. After saving user in UserService: {}", savedUser);

		return savedUser;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserByUsername(String username) {
		logger.info("Finding user by username: {}", username);
		return userRepository.findByUsername(username);
	}

	public Optional<User> getUserById(Long id) {
		logger.info("Finding user by id: {}", id);
		return userRepository.findById(id);
	}

	public Optional<User> getUserByEmail(String email) {
		logger.info("Finding user by email: {}", email);
		return userRepository.findByEmail(email);
	}

}
