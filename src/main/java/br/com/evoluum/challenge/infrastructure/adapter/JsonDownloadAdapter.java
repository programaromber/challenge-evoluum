package br.com.evoluum.challenge.infrastructure.adapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.infrastructure.util.DownloadAdapter;

@Component
public class JsonDownloadAdapter implements DownloadAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonDownloadAdapter.class);
	
	@Override
	public void process(List<ResponseDTO> result, HttpServletResponse response, String fileName) throws IOException {
		LOG.info(String.format("Generate file %s...", MediaType.APPLICATION_JSON_VALUE));                                    
        PrintWriter out = response.getWriter();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        out.print(new ObjectMapper().writeValueAsString(result));
        out.flush();               
        LOG.info(String.format("Finished generate file %s...", MediaType.APPLICATION_JSON_VALUE));                                    
	}
	
	
}
