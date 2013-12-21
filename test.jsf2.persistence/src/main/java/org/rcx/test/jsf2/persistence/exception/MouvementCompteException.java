package org.rcx.test.jsf2.persistence.exception;

public class MouvementCompteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MouvementCompteException(String message) {
		super(message);
	}

	public MouvementCompteException(Throwable th) {
		super(th);
	}

	public MouvementCompteException(String message, Throwable th) {
		super(message, th);
	}

}
