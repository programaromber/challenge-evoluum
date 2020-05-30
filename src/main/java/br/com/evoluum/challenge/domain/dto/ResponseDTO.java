package br.com.evoluum.challenge.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details of countys.")
public class ResponseDTO {
	
	@ApiModelProperty(notes = "ID of state")
	private int stateId;
	@ApiModelProperty(notes = "Abbreviation of state")
	private String stateAbbreviation;
	@ApiModelProperty(notes = "Name of region")
	private String regionName;
	@ApiModelProperty(notes = "Name of county")
	private String countyName;
	@ApiModelProperty(notes = "Name of mesoregion")
	private String mesoRegionName;   
	@ApiModelProperty(notes = "Description of county (format: [countyName]/[stateAbbreviation])")
	private String description;
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(County county) {
		this.stateId = county.getMicroRegion().getMesoRegion().getState().getId();
		this.stateAbbreviation = county.getMicroRegion().getMesoRegion().getState().getAbbreviation();
		this.regionName = county.getMicroRegion().getMesoRegion().getState().getRegion().getName();
		this.countyName = county.getName();
		this.mesoRegionName = county.getMicroRegion().getMesoRegion().getName();
		this.description = county.getName() + "/" + county.getMicroRegion().getMesoRegion().getState().getAbbreviation();
	}
	
	public ResponseDTO(State state) {
		this.stateId = state.getId();
		this.stateAbbreviation = state.getAbbreviation();
		this.regionName = state.getRegion().getName();
	}
	
	@JsonProperty("idEstado")
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	@JsonProperty("siglaEstado")
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	
	@JsonProperty("regiaoNome")
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	@JsonProperty("nomeCidade")
	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	@JsonProperty("nomeMesorregiao")
	public String getMesoRegionName() {
		return mesoRegionName;
	}

	public void setMesoRegionName(String mesoRegionName) {
		this.mesoRegionName = mesoRegionName;
	}
	
	@JsonProperty("nomeFormatado")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
