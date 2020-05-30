package br.com.evollum.challenge.api.exceptionhandler;

public class CountyNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -2882218145614977160L;

	public CountyNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
