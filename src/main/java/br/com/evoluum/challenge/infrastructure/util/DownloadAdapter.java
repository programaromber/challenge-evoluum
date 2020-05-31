package br.com.evoluum.challenge.infrastructure.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BusinessException;

public interface DownloadAdapter {

	public void run(List<ResponseDTO> result, HttpServletResponse response, String onlyState) throws BusinessException;
	
	public EnumResponseType getType();
	
}
