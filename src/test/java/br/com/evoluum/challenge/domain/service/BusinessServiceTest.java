package br.com.evoluum.challenge.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BusinessException;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@SpringBootTest
public class BusinessServiceTest {

	@Autowired
	private BusinessService service;
	
	@DisplayName("Service instance test")
	@Test
	public void serviceTest() {
		assertThat(service).isNotNull();
	}
	
	@DisplayName("Result of find all states test")
	@Test
	public void resultStatesTest() {
		final ResponseEntity<List<ResponseDTO>> result = service.findAllStates();
		assertThat(result.getBody()).isNotEmpty();
	}
	
	@DisplayName("Result of find countys by state test")
	@Test
	public void resultCountysByStateTest() {
		final ResponseEntity<List<ResponseDTO>> result = service.findCountysByState("rj");
		assertThat(result.getBody()).isNotEmpty();
	}
	
	@DisplayName("Result of find county by name test")
	@Test
	public void resultCountysByNameTest() {
		final ResponseEntity<Integer> result = service.findCountyByName("Belém");
		assertThat(result.getBody()).isNotNull();
	}
	
	@DisplayName("Create csv file of all states test")
	@Test
	public void resultStatesCsvFileDownloadTest() throws BusinessException, IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		service.findAllStatesforDownload(EnumResponseType.CSV, response);
		assertThat(response.getContentAsByteArray()).isNotNull();
	}
	
	@DisplayName("Create json file of all states test")
	@Test
	public void resultStatesJsonFileDownloadTest() throws BusinessException, IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		service.findAllStatesforDownload(EnumResponseType.JSON, response);
		assertThat(response.getContentAsByteArray()).isNotNull();
	}
	
	
	@DisplayName("Create csv file of countys by states test")
	@Test
	public void resultCountysByStateCsvFileDownloadTest() throws BusinessException, IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		service.findCountysByStateforDownload(EnumResponseType.CSV, response, "RJ");
		assertThat(response.getContentAsByteArray()).isNotNull();
	}
	
	@DisplayName("Create json file of countys by states test")
	@Test
	public void resultCountysByStateJsonFileDownloadTest() throws BusinessException, IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		service.findCountysByStateforDownload(EnumResponseType.JSON, response, "PA");
		assertThat(response.getContentAsByteArray()).isNotNull();
	}

}
