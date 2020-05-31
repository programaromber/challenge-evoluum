package br.com.evoluum.challenge.domain.exception;

public class BusinessException extends RuntimeException {


	private static final long serialVersionUID = 1126686696578227652L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
	public BusinessException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}