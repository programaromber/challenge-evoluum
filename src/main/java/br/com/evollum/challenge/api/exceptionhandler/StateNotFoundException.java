package br.com.evollum.challenge.api.exceptionhandler;

public class StateNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -2882218145614977160L;

	public StateNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
