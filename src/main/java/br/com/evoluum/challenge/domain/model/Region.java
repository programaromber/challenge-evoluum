package br.com.evoluum.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Region {

	private Integer id;
	private String abbreviation;
	private String name;

	public Region() {
		super();
	}

	public Region(Integer id, String abbreviation, String name) {
		super();
		this.id = id;
		this.abbreviation = abbreviation;
		this.name = name;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("sigla")
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@JsonProperty("nome")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
