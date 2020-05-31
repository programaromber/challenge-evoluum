package br.com.evoluum.challenge.infrastructure.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;
import br.com.evoluum.challenge.infrastructure.config.SourceProperties;

@Service
public class SourceService implements ISource {

	private static final Logger LOG = LoggerFactory.getLogger(SourceService.class);

	@Autowired
	private SourceProperties properties;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "emptyStates", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000") })
//	@Cacheable(cacheNames = "State", key="#root.method.name")
	public List<State> findAllStates() {
		LOG.info("Loading all states of Brazil...");
		List<State> response = Arrays
				.asList(restTemplate.getForEntity(properties.getSourceState(), State[].class).getBody());
		LOG.info("Finished loading all states of Brazil...");
		return response;
	}

	@Override
	@HystrixCommand(fallbackMethod = "emptyCountys", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000") })
	@Cacheable(cacheNames = "County", key="#root.method.name", unless="#result.isEmpty()")
	public List<County> findAllCounty() {
		LOG.info("Loading all countys of Brazil...");
		List<County> response = Arrays
				.asList(restTemplate.getForEntity(properties.getSourceCounty(), County[].class).getBody());
		LOG.info("Finished loading all countys of Brazil...");
		return response;
	}

	@Override
	@HystrixCommand(fallbackMethod = "emptyCountysByState", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000") })
//	@Cacheable(cacheNames = "County", key="#stateAbbreviation")
	public List<County> findCountysByState(String stateAbbreviation) {
		LOG.info("Loading all countys by state of Brazil...");
		List<County> response = Arrays
				.asList(restTemplate.getForEntity(String.format(properties.getSourceStateCounty(), stateAbbreviation), County[].class).getBody());
		LOG.info("Finished loading all countys by state of Brazil...");
		return response;
	}
	
	public List<State> emptyStates() {
		return new ArrayList<State>();
	}
	
	public List<County> emptyCountys() {
		return new ArrayList<County>();
	}
	
	public List<County> emptyCountysByState(String stateAbbreviation) {
		return new ArrayList<County>();
	}
	
	
}
