package model.exception;

public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//criar uma funcao para receber uma msg
	public DomainException (String msg) {
		super(msg);
	}
}
