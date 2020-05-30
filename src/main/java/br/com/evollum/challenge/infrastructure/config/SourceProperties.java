package br.com.evollum.challenge.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:source.properties")
public class SourceProperties {

	@Value("${source.ibge.state.url}")
	private String sourceState;

	@Value("${source.ibge.county.url}")
	private String sourceCounty;

	@Value("${source.ibge.state.county.url}")
	private String sourceStateCounty;

	public SourceProperties() {
		super();
	}

	public String getSourceState() {
		return sourceState;
	}

	public void setSourceState(String sourceState) {
		this.sourceState = sourceState;
	}

	public String getSourceCounty() {
		return sourceCounty;
	}

	public void setSourceCounty(String sourceCounty) {
		this.sourceCounty = sourceCounty;
	}

	public String getSourceStateCounty() {
		return sourceStateCounty;
	}

	public void setSourceStateCounty(String sourceStateCounty) {
		this.sourceStateCounty = sourceStateCounty;
	}

}
