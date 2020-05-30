package br.com.evoluum.challenge.api.exceptionhandler;

import br.com.evoluum.challenge.domain.exception.BussinesException;

public abstract class EntityNotFoundException extends BussinesException {

	private static final long serialVersionUID = 6010305857817799969L;

	public EntityNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
