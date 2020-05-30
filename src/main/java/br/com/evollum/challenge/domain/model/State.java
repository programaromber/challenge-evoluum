package br.com.evollum.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State {
	private Integer id;
	private String name;
	private String abbreviation;
	private Region region;

	public State() {
		super();
	}

	public State(Integer id, String name, String abbreviation, Region region) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
		this.region = region;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("nome")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("sigla")
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@JsonProperty("regiao")
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
