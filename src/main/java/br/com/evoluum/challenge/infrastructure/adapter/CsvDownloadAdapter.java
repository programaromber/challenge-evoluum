package br.com.evoluum.challenge.infrastructure.adapter;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
import br.com.evoluum.challenge.domain.exception.BussinesException;
import br.com.evoluum.challenge.infrastructure.util.ChallengeUtil;
import br.com.evoluum.challenge.infrastructure.util.DownloadAdapter;
import br.com.evoluum.challenge.infrastructure.util.EnumResponseType;

@Component
public class CsvDownloadAdapter implements DownloadAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(CsvDownloadAdapter.class);

	@Override
	public void run(List<ResponseDTO> result, HttpServletResponse response, String stateAbbreviation) throws BussinesException {
		try {
			LOG.info(String.format("Generate file %s...", ChallengeUtil.CONTENT_TYPE_CSV));
			byte[] data = ChallengeUtil.createCsv(result, stateAbbreviation != null);
			response.setHeader("Content-Disposition", this.contentDisposition(stateAbbreviation));
			response.setContentType(ChallengeUtil.CONTENT_TYPE_CSV);
			response.setContentLength(data.length);
			response.getOutputStream().write(data);
			LOG.info(String.format("Finished generate file %s...", ChallengeUtil.CONTENT_TYPE_CSV));
		} catch (IOException e) {
			throw new BussinesException(e.getLocalizedMessage(), e);
		}
		
	}

	@Override
	public EnumResponseType getType() {
		return EnumResponseType.CSV;
	}
	
	private String contentDisposition(String stateAbbreviation) {
		return String.format("attachment; filename=\"%s\"", ChallengeUtil.getFileName(stateAbbreviation, getType()));
	}


}
