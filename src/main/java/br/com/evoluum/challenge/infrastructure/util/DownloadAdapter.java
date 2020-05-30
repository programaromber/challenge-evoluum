package br.com.evoluum.challenge.infrastructure.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;

public interface DownloadAdapter {

	public void process(List<ResponseDTO> result, HttpServletResponse response, String fileName) throws IOException;
	
}
