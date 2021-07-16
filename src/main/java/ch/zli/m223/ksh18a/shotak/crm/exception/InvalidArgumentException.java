package ch.zli.m223.ksh18a.shotak.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad argument")
public class InvalidArgumentException extends NoStackTraceException {
	public InvalidArgumentException() {
	}

}
