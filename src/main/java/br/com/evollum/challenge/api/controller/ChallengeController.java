package br.com.evollum.challenge.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evollum.challenge.domain.model.County;
import br.com.evollum.challenge.domain.model.State;
import br.com.evollum.challenge.domain.service.ChallengeService;
import br.com.evollum.challenge.infrastructure.service.SourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api/v1")
@Api(tags = { "ENDPOINTS FOR IBGE SOURCE" })
public class ChallengeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SourceService.class);
	
	private ChallengeService service;
	
	@Autowired
	public ChallengeController(ChallengeService service) {
		this.service = service;
	}
	

	@GetMapping("/states")
	@ApiOperation(value = "Find all states.")
	@ApiResponses(value = {
//		@ApiResponse(code = 200, message = "Sucesso"),
//		@ApiResponse(code = 404, message = "Recurso não encontrado")
	})
	public ResponseEntity<List<State>> getAllStates() {
		LOG.info(String.format("Initializing the request for find all states..."));	
		ResponseEntity<List<State>> response = service.findAllStates();
		LOG.info("Request finished for find all states...");
		return response;
	}
	
	@GetMapping("/states/{stateAbbreviation}/countys")
	@ApiOperation(value = "Busca de município por nome, por exemplo 'Chapecó', todos os retornos serão salvos em cache, e toda meia noite são renovados.")
	@ApiResponses(value = {
//		@ApiResponse(code = 200, message = "Sucesso"),
//		@ApiResponse(code = 404, message = "Recurso não encontrado")
	})
	public ResponseEntity<List<County>> getCountysByState(@PathVariable String stateAbbreviation) {
		LOG.info(String.format("Initializing the request for find countys of state of %s...", stateAbbreviation));
		ResponseEntity<List<County>> response = service.findCountysByState(stateAbbreviation);
		LOG.info(String.format("Request finished for find countys of state of %s...", stateAbbreviation));		
		return response;
	}
	
//	@GetMapping("/states")
//	@ApiOperation(value = "Retorna todos os municípios por tipo, por exemplo 'CSV', e se o timeout passar de 30 segundos, se passar disso irá retornar uma lista vazia.")
//	@ApiResponses(value = {
////		@ApiResponse(code = 200, message = "Sucesso"),
////		@ApiResponse(code = 404, message = "Recurso não encontrado")
//	})
//	public ResponseEntity<Object> getAll(@PathVariable TipoRetornoEnum returnType, HttpServletResponse httpResponse) {
//		LOG.info(String.format("Initializing the request for find all states for return type %s.", stateAbbreviation));	
//		service.findAllStates();
//		LOG.info("Finalizado processamento para para todos os dados, tipo: " + returnType.getValue());		
//
//		return ResponseEntity.status(httpResponse.getContentType() == null ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(null);
//	}
//	
}
