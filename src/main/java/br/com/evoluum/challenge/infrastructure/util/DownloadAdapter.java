package br.com.evoluum.challenge.infrastructure.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BussinesException;

public interface DownloadAdapter {

	public void run(List<ResponseDTO> result, HttpServletResponse response, String onlyState) throws BussinesException;
	
	public EnumResponseType getType();
	
}
