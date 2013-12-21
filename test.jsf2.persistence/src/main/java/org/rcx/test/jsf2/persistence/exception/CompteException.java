package org.rcx.test.jsf2.persistence.exception;

public class CompteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CompteException(String message) {
		super(message);
	}

	public CompteException(Throwable th) {
		super(th);
	}

	public CompteException(String message, Throwable th) {
		super(message, th);
	}

}
