package com.vti.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.service.IEmailService;

//Class nay se implement OnSendRegistrationUserConfirmViaEmailEvent va gui xac nhan cho User qua email

@Component
public class SendRegistrationUserConfirmViaEmailListener
		implements ApplicationListener<OnSendRegistrationUserConfirmViaEmailEvent> {

	@Autowired 
	private IEmailService emailService;
	
	@Override
	public void onApplicationEvent(OnSendRegistrationUserConfirmViaEmailEvent event) {
		sendConfirmViaEmail(event.getEmail());
	}

	/* Gui xac nhan la User da dang ki */
	private void sendConfirmViaEmail(String email) {
		emailService.SendRegistrationUserConfirm(email);
	}
}
