package br.com.evoluum.challenge.infrastructure.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.model.County;
import br.com.evoluum.challenge.domain.model.State;

@Component
public class ChallengeUtil {
	
	public static final String CONTENT_TYPE_CSV = "text/csv; charset=utf-8";
	
	public static byte[] createCsv(List<ResponseDTO> result,  boolean onlyState) {
		String separator = ";";
		StringBuilder sb = new StringBuilder();
		sb.append("idEstado;siglaEstado;regiaoNome");
		if(onlyState) {
			sb.append(";nomeCidade;nomeMesorregiao;nomeFormatado");
		}
		sb.append("\n");
		sb.append(System.lineSeparator());
		for (ResponseDTO respose : result) {
			sb.append(respose.getStateId()).append(separator);
			sb.append(respose.getStateAbbreviation()).append(separator);
			sb.append(respose.getRegionName()).append(separator);
			if(onlyState) {
				sb.append(respose.getCountyName()).append(separator);
				sb.append(respose.getMesoRegionName()).append(separator);
				sb.append(respose.getDescription()).append(separator);
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString().getBytes();
	}
	
	public static byte[] createJson(List<ResponseDTO> result) throws JsonProcessingException {
		StringBuilder sb = new StringBuilder();
		sb.append(new ObjectMapper().writeValueAsString(result));
		return sb.toString().getBytes();
	}
	
	public static List<ResponseDTO> statesToDTOs(List<State> result) {
		return result.stream().map(r -> new ResponseDTO(r)).collect(Collectors.toList());
	}
	
	public static List<ResponseDTO> countysToDTOs(List<County> result) {
		return result.stream().map(r -> new ResponseDTO(r)).collect(Collectors.toList());
	}

	public static String getfileNameCounty(String stateAbbreviation, EnumResponseType responseType) {
		return String.format("all-countys-of-state-%s-of-brazil.%s", stateAbbreviation.toLowerCase(), responseType.getValue().toLowerCase());
	}
	
	public static String getfileNameState(EnumResponseType responseType) {
		return String.format("all-states-of-brazil.%s", responseType.getValue().toLowerCase());
	}
	
	public static String getFileName(String stateAbbreviation, EnumResponseType responseType) {
		return stateAbbreviation == null ? getfileNameState(responseType) :
			getfileNameCounty(stateAbbreviation, responseType) ;
	}

	
}
