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
		public void process(List<ResponseDTO> result, HttpServletResponse response, String fileName) throws IOException{
			new CsvDownloadAdapter().process(result, response, fileName);
		}
	}, 
	JSON("JSON") {
		@Override
		public void process(List<ResponseDTO> result, HttpServletResponse response, String fileName) throws IOException{
			new JsonDownloadAdapter().process(result, response, fileName);
		}
	};

	private final String value;

	EnumResponseType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public abstract void process(List<ResponseDTO> result, HttpServletResponse response, String fileName) throws IOException;
}
