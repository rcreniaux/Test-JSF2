package org.rcx.test.jsf2.persistence.exception;

public class FavTrendException extends Exception {

	private static final long serialVersionUID = 1L;

	public FavTrendException(String message) {
		super(message);
	}

	public FavTrendException(Throwable th) {
		super(th);
	}

	public FavTrendException(String message, Throwable th) {
		super(message, th);
	}
	
}
