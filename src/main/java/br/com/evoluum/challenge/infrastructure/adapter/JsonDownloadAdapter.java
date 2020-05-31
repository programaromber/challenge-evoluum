package br.com.evoluum.challenge.infrastructure.adapter;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BussinesException;
import br.com.evoluum.challenge.infrastructure.util.ChallengeUtil;
import br.com.evoluum.challenge.infrastructure.util.DownloadAdapter;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@Component
public class JsonDownloadAdapter implements DownloadAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonDownloadAdapter.class);
	
	@Override
	public void run(List<ResponseDTO> result, HttpServletResponse response, String stateAbbreviation) throws BussinesException {
		try {
		LOG.info(String.format("Generate file %s...", MediaType.APPLICATION_JSON_VALUE));                                    
		byte[] data = ChallengeUtil.createJson(result);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"",this.contentDisposition()));
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setContentLength(data.length);
		response.getOutputStream().write(data);
        LOG.info(String.format("Finished generate file %s...", MediaType.APPLICATION_JSON_VALUE));
		} catch (JsonProcessingException e) {
			throw new BussinesException(e.getLocalizedMessage(), e);
		} catch (IOException e) {
			throw new BussinesException(e.getLocalizedMessage(), e);
		}
	}
	
	
	@Override
	public EnumResponseType getType() {
		return EnumResponseType.JSON;
	}
	
	private String contentDisposition() {
		return String.format("attachment; filename=\"%s\"", ChallengeUtil.getFileName(null, getType()));
	}
	
	
	
}
