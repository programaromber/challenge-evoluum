package br.com.evoluum.challenge.infrastructure.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.infrastructure.adapter.CsvDownloadAdapter;
import br.com.evoluum.challenge.infrastructure.adapter.JsonDownloadAdapter;

public enum EnumResponseType {

	CSV("CSV") {
		@Override
		public void run(List<ResponseDTO> result, HttpServletResponse response, String stateAbbreviation) throws IOException{
			new CsvDownloadAdapter().run(result, response, stateAbbreviation);
		}
	}, 
	JSON("JSON") {
		@Override
		public void run(List<ResponseDTO> result, HttpServletResponse response, String stateAbbreviation) throws IOException{
			new JsonDownloadAdapter().run(result, response, stateAbbreviation);
		}
	};

	private final String value;

	EnumResponseType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public abstract void run(List<ResponseDTO> result, HttpServletResponse response, String stateAbbreviation) throws IOException;
}
