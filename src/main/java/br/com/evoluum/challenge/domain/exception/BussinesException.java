package br.com.evoluum.challenge.domain.exception;

public class BussinesException extends RuntimeException {


	private static final long serialVersionUID = 1126686696578227652L;

	public BussinesException(String mensagem) {
		super(mensagem);
	}
	
	public BussinesException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}