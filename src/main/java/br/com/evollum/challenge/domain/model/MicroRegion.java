package br.com.evollum.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicroRegion {
	
	private Integer id;
	private String name;
	private MesoRegion mesoRegion;

	public MicroRegion() {
		super();
	}

	public MicroRegion(Integer id, String name, MesoRegion mesoRegion) {
		super();
		this.id = id;
		this.name = name;
		this.mesoRegion = mesoRegion;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("mesorregiao")
	public MesoRegion getMesoRegion() {
		return mesoRegion;
	}

	public void setMesoRegion(MesoRegion mesoRegion) {
		this.mesoRegion = mesoRegion;
	}
}
