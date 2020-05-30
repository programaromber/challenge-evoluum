package br.com.evollum.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class County {
	
	private Integer id;
	private String name;
	private MicroRegion microRegion;

	public County() {
		super();
	}

	public County(Integer id, String name, MicroRegion microRegion) {
		super();
		this.id = id;
		this.name = name;
		this.microRegion = microRegion;
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
	
	@JsonProperty("microrregiao")
	public MicroRegion getMicroRegion() {
		return microRegion;
	}

	public void setMicroRegion(MicroRegion microRegion) {
		this.microRegion = microRegion;
	}
}
