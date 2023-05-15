package com.empl.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(EmpException.class)
	public ErrorResponse handleUserException(EmpException ue) {
		return new ErrorResponse(ue.getMsg(),101);
	}

}

