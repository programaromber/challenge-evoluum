package br.com.evoluum.challenge.domain.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.evoluum.challenge.api.exceptionhandler.EntityNotFoundException;
import br.com.evoluum.challenge.domain.exception.BussinesException;
import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;
import br.com.evoluum.challenge.infrastructure.service.SourceService;
import br.com.evoluum.challenge.infrastructure.util.ChallengeUtil;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@Service
public class ChallengeService {

	private SourceService service;

	@Autowired
	public ChallengeService(SourceService service) {
		this.service = service;
	}

	public ResponseEntity<List<State>> findAllStates() {

		Optional<List<State>> result = service.findAllStates();

		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<List<County>> findAllCounty() {

		Optional<List<County>> result = service.findAllCounty();

		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<List<County>> findCountysByState(String stateAbbreviation) {

		Optional<List<County>> result = service.findCountysByState(stateAbbreviation);

		if (result.isPresent()) {
			return ResponseEntity.ok(result.get());
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Integer> findCountyByName(String name) {
		Optional<List<County>> result = service.findAllCounty();

		if (result.isPresent()) {
			return ResponseEntity.ok(
					result.get().stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst().get().getId());
		}
		return ResponseEntity.notFound().build();
	}

	public void findAllStatesforDownload(EnumResponseType responseType, HttpServletResponse response) throws BussinesException, IOException {
		
		Optional<List<State>> result = service.findAllStates();
		
		if (result.isPresent() && !result.get().isEmpty()) {
			responseType.process(ChallengeUtil.statesToDTOs(result.get()), response, ChallengeUtil.getfileNameState(responseType));
		} else {
			throw new BussinesException("Result not found.");
		}
	}
	
	public void findCountysByStateforDownload(EnumResponseType responseType, HttpServletResponse response, String stateAbbreviation) throws BussinesException, IOException {
		
		Optional<List<County>> result = service.findCountysByState(stateAbbreviation);
		
		if (result.isPresent() && !result.get().isEmpty()) {
			responseType.process(ChallengeUtil.countysToDTOs(result.get()), response, ChallengeUtil.getfileNameCounty(stateAbbreviation, responseType));
		} else {
			throw new BussinesException("Result not found.");
		}
	}
}
