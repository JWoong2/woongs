package spring.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginCommand {
	private String userId;
	private String password;
}