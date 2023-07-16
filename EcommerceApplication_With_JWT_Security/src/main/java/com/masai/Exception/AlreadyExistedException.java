package com.masai.Exception;

public class AlreadyExistedException extends RuntimeException {

	public AlreadyExistedException() {
		super();
	}

	public AlreadyExistedException(String message) {
		super(message);
	}

}
