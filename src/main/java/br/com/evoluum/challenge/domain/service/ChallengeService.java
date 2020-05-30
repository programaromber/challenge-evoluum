package br.com.evoluum.challenge.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;
import br.com.evoluum.challenge.infrastructure.service.SourceService;

@Service
public class ChallengeService {
	
	
	private SourceService service;
	
	@Autowired
	public ChallengeService(SourceService service) {
		this.service = service;
	}
	
	public ResponseEntity<List<State>> findAllStates() {
		
		Optional<List<State>> response = service.findAllStates();
		
		if(response.isPresent()) {
			return ResponseEntity.ok(response.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<List<County>> findAllCounty() {
			
			Optional<List<County>> response = service.findAllCounty();
			
			if(response.isPresent()) {
				return ResponseEntity.ok(response.get());
			}
			
			return ResponseEntity.notFound().build();
		}
	
	public ResponseEntity<List<County>> findCountysByState(String stateAbbreviation) {
		
		Optional<List<County>> response = service.findCountysByState(stateAbbreviation);
		
		if(response.isPresent()) {
			return ResponseEntity.ok(response.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}
