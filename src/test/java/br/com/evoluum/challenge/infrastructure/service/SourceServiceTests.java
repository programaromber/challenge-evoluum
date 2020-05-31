package br.com.evoluum.challenge.infrastructure.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;

@SpringBootTest
public class SourceServiceTests {

	@Autowired
	private SourceService service;
	
	@DisplayName("Service instance test")
	@Test
	public void serviceTest() {
		assertThat(service).isNotNull();
	}
	
	@DisplayName("Find all states test")
	@Test
	public void integrationStatesTest() {
		final List<State> result = service.findAllStates();
		assertThat(result).isNotEmpty();
	}
	
	@DisplayName("Find all countys test")
	@Test
	public void countysTest() {
		final List<County> result = service.findAllCounty();
		assertThat(result).isNotEmpty();
	}
	
	@DisplayName("Find countys by state test")
	@Test
	public void countysByStateTest() {
		final List<County> result = service.findCountysByState("rj");
		assertThat(result).isNotEmpty();
	}
}
