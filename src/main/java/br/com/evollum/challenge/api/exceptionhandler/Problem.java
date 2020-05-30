package br.com.evollum.challenge.api.exceptionhandler;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
public class Problem {

	@ApiModelProperty(example = "400", position = 1)
	private int status;

	@ApiModelProperty(example = "2019-12-01T18:09:02.70844Z", position = 5)
	private OffsetDateTime timestamp;

	@ApiModelProperty(example = "https://localhost:8080/dados-invalidos", position = 10)
	private String type;

	@ApiModelProperty(example = "Invalid data", position = 15)
	private String title;

	@ApiModelProperty(example = "One or more invalid fields.", position = 25)
	private String message;

	public Problem(int status, OffsetDateTime timestamp, String type, String title, String message) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.type = type;
		this.title = title;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
