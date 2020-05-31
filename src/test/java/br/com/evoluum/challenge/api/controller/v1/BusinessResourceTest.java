package br.com.evoluum.challenge.api.controller.v1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BusinessException;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@SpringBootTest
@AutoConfigureMockMvc
public class BusinessResourceTest {
	
	private final String password = "Basic ZXZvbHV1bTpmNTc2NjJiNDBkMzYxZTM4ODJlOWY0YzU5MjBiMmVhYTk4Mjk0ZGIyYTM0NzIwZTNiOGZhMGQ0ODk1OTY0ZDgz";
	private final String typeAuthenticated = "Authorization";
	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("Unauthorized Test")
	@Test
	public void unautorizedTest() throws Exception {
		mockMvc.perform(get("/api/v1/states")).andExpect(status().is4xxClientError());
	}
	
	@DisplayName("Request for all states test")
	@Test
	public void requestForAllStatesTest() throws Exception {
		mockMvc.perform(get("/api/v1/states")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for county by state test")
	@Test
	public void requestForCountysByStateTest() throws Exception {
		mockMvc.perform(get("/api/v1/states/pa/countys")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for county by name test")
	@Test
	public void requestForCountyByNameTest() throws Exception {
		mockMvc.perform(get("/api/v1/countys/abaetetuba")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for all states CSV file download test")
	@Test
	public void requestForAllStatesCsvFileDownloadTest() throws Exception {
		mockMvc.perform(get("/api/v1/states/CSV")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for all states JSON file download test")
	@Test
	public void requestForAllStatesJsonFileDownloadTest() throws Exception {
		mockMvc.perform(get("/api/v1/states/JSON")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for countys by state CSV file download test")
	@Test
	public void requestForCountysByStateCsvFileDownloadTest() throws Exception {
		mockMvc.perform(get("/api/v1/states/pa/countys/CSV")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}
	
	@DisplayName("Request for countys by state JSON file download test")
	@Test
	public void requestForCountysByStateJsonFileDownloadTest() throws Exception {
		mockMvc.perform(get("/api/v1/states/pa/countys/JSON")
						.header(typeAuthenticated, password))
						.andExpect(status().isOk());
	}

}
