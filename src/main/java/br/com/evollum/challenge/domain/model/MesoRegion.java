package br.com.evollum.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesoRegion {
	
	private Integer id;
	private String name;
	private State state;

	public MesoRegion() {
		super();
	}

	public MesoRegion(Integer id, String name, State state) {
		this.id = id;
		this.name = name;
		this.state = state;
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
	
	@JsonProperty("UF")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


}
