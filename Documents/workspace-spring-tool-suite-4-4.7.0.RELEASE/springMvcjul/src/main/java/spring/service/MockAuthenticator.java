package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import spring.common.CommonLogger;

@Component
public class MockAuthenticator implements Authenticator {

	@Setter
	@Autowired
	private CommonLogger commonLogger;

	public void authenticate(LoginCommand loginCommand) throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			commonLogger.log("인증 에러 - " + loginCommand.getUserId());
			throw new AuthenticationException();
		}
	}

}