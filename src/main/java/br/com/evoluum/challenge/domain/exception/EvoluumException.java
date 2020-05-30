package br.com.evoluum.challenge.domain.exception;

public class EvoluumException extends RuntimeException {


	private static final long serialVersionUID = 1126686696578227652L;

	public EvoluumException(String mensagem) {
		super(mensagem);
	}
	
	public EvoluumException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}