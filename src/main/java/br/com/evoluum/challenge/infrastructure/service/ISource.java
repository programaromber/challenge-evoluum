package br.com.evoluum.challenge.infrastructure.service;

import java.util.List;

import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;


public interface ISource {
	
	 public List<State> findAllStates();
	 
	 public List<County> findAllCounty();
	 
	 public List<County> findCountysByState (final String county);
	
}
