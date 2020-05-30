package br.com.evollum.challenge.api.exceptionhandler;

import br.com.evollum.challenge.domain.exception.EvoluumException;

public abstract class EntityNotFoundException extends EvoluumException {

	private static final long serialVersionUID = 6010305857817799969L;

	public EntityNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
