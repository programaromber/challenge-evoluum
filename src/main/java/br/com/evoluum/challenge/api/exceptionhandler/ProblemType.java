package br.com.evoluum.challenge.api.exceptionhandler;

public enum ProblemType {

	INVALID_DATA("/error", "INVALID DATA"), 
	SYSTEM_ERROR("/error", "SYSTEM ERROR"),
	INVALD_PARAMETER("/error", "INVALD PARAMETER"),
	GENERIC_ERROR("/error", "GENERIC ERROR"),
	RESOURCE_NOT_FOUND("/error", "RESOURCE NOT FOUND"),
	BUSSINES_ERROR("/error", "BUSSINES ERROR");

	private String title;
	private String uri;

	ProblemType(String path, String title) {
		this.uri = "https://localhost:8080" + path;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
