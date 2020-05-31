package br.com.evoluum.challenge.api.controller.v1;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BusinessException;
import br.com.evoluum.challenge.domain.service.BusinessService;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/v1")
@Api(tags = { "ENDPOINTS FOR IBGE SOURCE" })
public class BusinessResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(BusinessResource.class);
	
	private BusinessService service;
	
	@Autowired
	public BusinessResource(BusinessService service) {
		this.service = service;
	}

	@GetMapping("/states")
	@ApiOperation(value = "Find all states json format.")
	public ResponseEntity<List<ResponseDTO>> getAllStates() {
		LOG.info(String.format("Initializing the request for find all states..."));	
		ResponseEntity<List<ResponseDTO>> response = service.findAllStates();
		LOG.info("Request finished for find all states...");
		return response;
	}
	
	@GetMapping("/states/{stateAbbreviation}/countys")
	@ApiOperation(value = "find all countys json format.")
	public ResponseEntity<List<ResponseDTO>> getCountysByState(@PathVariable String stateAbbreviation) {
		LOG.info(String.format("Initializing the request for find countys of state of %s...", stateAbbreviation));
		ResponseEntity<List<ResponseDTO>> response = service.findCountysByState(stateAbbreviation);
		LOG.info(String.format("Request finished for find countys of state of %s...", stateAbbreviation));		
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/states/{responseType}")
	@ApiOperation(value = "find all states retunring in file.")
	public ResponseEntity findAllStatesforDownload(@PathVariable EnumResponseType responseType, HttpServletResponse httpResponse) throws BusinessException, IOException {
		LOG.info(String.format("Initializing the request for find all states to file type %s...", responseType.getValue()));
		service.findAllStatesforDownload(responseType, httpResponse);
		LOG.info(String.format("Finalizado processamento para para todos os dados, tipo: ", responseType.getValue()));
		LOG.info(String.format("Request finished for find all states to file type %s...", responseType.getValue()));	
		return ResponseEntity.ok().build();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/states/{stateAbbreviation}/countys/{responseType}")
	@ApiOperation(value = "find all countys to state in file.")
	public ResponseEntity findCountysByStateforDownload(@PathVariable String stateAbbreviation, @PathVariable EnumResponseType responseType,  HttpServletResponse httpResponse) throws BusinessException, IOException {
		LOG.info(String.format("Initializing the request for find countys of state of %s to file type %s...", stateAbbreviation, responseType.getValue()));
		service.findCountysByStateforDownload(responseType, httpResponse, stateAbbreviation);
		LOG.info(String.format("Request finished for find countys of state of %s to file type %s...", stateAbbreviation, responseType.getValue()));		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/countys/{name}")
	@ApiOperation(value = "Find county for name and returning id")
	public ResponseEntity<Integer> getCountyByName(@PathVariable String name) {
		LOG.info(String.format("Initializing the request for find county by name %s...", name));
		ResponseEntity<Integer> response = service.findCountyByName(name);
		LOG.info(String.format("Request finished for find county by name %s...", name));
		return response;
	}
	
}
