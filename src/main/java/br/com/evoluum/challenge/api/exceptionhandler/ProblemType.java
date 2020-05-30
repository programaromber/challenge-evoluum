package br.com.evoluum.challenge.api.exceptionhandler;

public enum ProblemType {

	INVALID_DATA("/dados-invalidos", "Dados inválidos"), 
	SYSTEM_ERROR("/erro-de-sistema", "Erro de sistema"),
	INVALD_PARAMETER("/parametro-invalido", "Parâmetro inválido"),
	GENERIC_ERROR("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RESOURCE_NOT_FOUND("/recurso-nao-encontrado", "Recurso não encontrado"),
	BUSSINES_ERROR("/erro-negocio", "Violação de regra de negócio");

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
