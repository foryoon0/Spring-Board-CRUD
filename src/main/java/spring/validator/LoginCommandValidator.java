package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.LoginCommand;

public class LoginCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 아이디를 입력을 했는지?
		// 암호는 입력을 했는지?
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberPassword", "required");
		
	}

	
}
