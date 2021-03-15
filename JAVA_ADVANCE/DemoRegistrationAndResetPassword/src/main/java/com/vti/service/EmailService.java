package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.vti.entity.User;
import com.vti.repository.RegistrationUserTokenRepository;

@Component
public class EmailService implements IEmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private IUserService userService;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Override
	public void SendRegistrationUserConfirm(String email) {
		/*
		 * String recipientEmail: email cua nguoi nhan String subject : tieu de String
		 * content: noi dung
		 */

		// Tu Email => User nao => token
		User user = userService.findUserByEmail(email);
		String token = registrationUserTokenRepository.findByUserId(user.getId());

		String confirmationUrl = "http://localhost:8080/api/v1/Users/activeUser?token=" + token;
		String subject = "Xác nhận đăng ký Account!";
		String content = "Bạn đã đăng ký thành công. Bấm vào link dưới để kích hoạt tài khoản\n" + confirmationUrl;
		
		sendEmail(email, subject, content);

	}

	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage mailMessages = new SimpleMailMessage();
		mailMessages.setTo(recipientEmail);
		mailMessages.setSubject(subject);
		mailMessages.setText(content);
		mailSender.send(mailMessages);
	}
}
