package com.vti.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.entity.RegistrationUserToken;
import com.vti.entity.User;
import com.vti.entity.UserStatus;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.repository.RegistrationUserTokenRepository;
import com.vti.repository.UserRepository;

@Service
@Transactional
//Roll back if meet a error

public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private ApplicationEventPublisher event;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createUser(User user) {

		// B0: encode password (ma hoa password)
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// B1: create User
		user = userRepository.save(user);

		// B2: Create New Token for new Registration
		createNewRegistrationUserToken(user);

		// B3: Send email to confirm registration
		sendConfirmRegistrationViaEmail(user.getEmail());
	}

	/* Tao token cho User moi dang ky tai khoan */
	private void createNewRegistrationUserToken(User user) {
		final String newToken = UUID.randomUUID().toString();
		RegistrationUserToken token = new RegistrationUserToken(newToken, user);
		registrationUserTokenRepository.save(token);
	}

	/* Phat di 1 cai thong bao la muon gui Confirm den nguoi dung thong qua email */
	private void sendConfirmRegistrationViaEmail(String email) {
		event.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void activeUser(String token) {

		RegistrationUserToken userToken = registrationUserTokenRepository.findByToken(token);
		User user = userToken.getUser();
		user.setStatus(UserStatus.ACTIVE);
		userRepository.save(user);

		// remove token de tranh bi active lai va don rac
		registrationUserTokenRepository.deleteByUserId(userToken.getId());
	}

	public boolean isUsernameExist(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean isEmailExist(String email) {
		return userRepository.existsByEmail(email);
	}

}
