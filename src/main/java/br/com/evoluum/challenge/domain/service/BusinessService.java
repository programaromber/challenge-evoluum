package br.com.evoluum.challenge.domain.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BusinessException;
import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;
import br.com.evoluum.challenge.infrastructure.service.SourceService;
import br.com.evoluum.challenge.infrastructure.util.ChallengeUtil;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@Service
public class BusinessService {

	private SourceService service;

	@Autowired
	public BusinessService(SourceService service) {
		this.service = service;
	}

	public ResponseEntity<List<ResponseDTO>> findAllStates() {

		List<State> result = service.findAllStates();

		if (Optional.of(result).isPresent()) {
			return ResponseEntity.ok(ChallengeUtil.statesToDTOs(result));
		}

		return ResponseEntity.notFound().build();
	}


	public ResponseEntity<List<ResponseDTO>> findCountysByState(String stateAbbreviation) {

		List<County> result = service.findCountysByState(stateAbbreviation);

		if (Optional.of(result).isPresent()) {
			return ResponseEntity.ok(ChallengeUtil.countysToDTOs(result));
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Integer> findCountyByName(String name) {
		List<County> result = service.findAllCounty();

		if (Optional.of(result).isPresent()) {
			return ResponseEntity.ok(
					result.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst().get().getId());
		}
		return ResponseEntity.notFound().build();
	}

	public void findAllStatesforDownload(EnumResponseType responseType, HttpServletResponse response) throws BusinessException, IOException {
		
		List<State> result = service.findAllStates();
		
		if (Optional.of(result).isPresent() && !result.isEmpty()) {
			responseType.run(ChallengeUtil.statesToDTOs(result), response, null);
		} else {
			throw new BusinessException("Result not found.");
		}
	}
	
	public void findCountysByStateforDownload(EnumResponseType responseType, HttpServletResponse response, String stateAbbreviation) throws BusinessException, IOException {
		
		List<County> result = service.findCountysByState(stateAbbreviation);
		
		if (Optional.of(result).isPresent() && !result.isEmpty()) {
			responseType.run(ChallengeUtil.countysToDTOs(result), response, stateAbbreviation);
		} else {
			throw new BusinessException("Result not found.");
		}
	}
}
