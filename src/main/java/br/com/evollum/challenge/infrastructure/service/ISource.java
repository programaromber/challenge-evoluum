package br.com.evollum.challenge.infrastructure.service;

import java.util.List;
import java.util.Optional;

import br.com.evollum.challenge.domain.model.County;
import br.com.evollum.challenge.domain.model.State;


public interface ISource {
	
	 public Optional<List<State>> findAllStates();
	 
	 public Optional<List<County>> findAllCounty();
	 
	 public Optional<List<County>> findCountysByState (final String county);
	
}
