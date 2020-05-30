package br.com.evoluum.challenge.infrastructure.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(apiInfo())
						.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages())
						.securitySchemes(Arrays.asList(apiKey()))
						.select()
						.apis(RequestHandlerSelectors.basePackage("br.com.evollum.challenge.api.controller"))
						.paths(PathSelectors.any())
						.build();
	}
	
	
	private ApiInfo apiInfo() {
		
		
		return new ApiInfoBuilder().title("Project for Challenge Evoluum")
				.description("API for querying states and countys of Brazil, <a href='https://servicodados.ibge.gov.br/api/docs/localidades'>click here</a> to enter source page. ")
				.termsOfServiceUrl("https://github.com/rafasall/challenge-evoluum")
				.contact(new Contact("Rafael Salles", "https://github.com/rafasall", "rafaelsalles.sistemas@gmail.com.com.brm"))
				.version("1.0").build();
	}
	
    @SuppressWarnings("deprecation")
	@Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(null, null, null, null, "", ApiKeyVehicle.HEADER, "Authorization", "");
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
    
    private List<ResponseMessage> getCustomizedResponseMessages(){
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(200).message("Está requisição foi bem sucedida.").build());
        responseMessages.add(new ResponseMessageBuilder().code(201).message("A requisição foi bem sucedida e um novo recurso foi criado como resultado").build());
        responseMessages.add(new ResponseMessageBuilder().code(400).message("Solicitação incorreta - Isso significa que a entrada do lado do cliente falha na validação").build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("Não autorizado - Isso significa que o usuário não está autorizado a acessar um recurso. Geralmente retorna quando o usuário não ésta autenticado").build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("Proibido - Isso significa que o usuário está autenticado, mas não tem permissão para acessar um recurso").build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("Não encontrado - indica que um recurso não foi encontrado").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("Erro interno do servidor - Este é um erro genérico do servidor. Provavelmente não deve ser lançado explicitamente").build());
        responseMessages.add(new ResponseMessageBuilder().code(502).message("Gateway inválido - indica uma resposta inválida de um servidor upstream").build());
        responseMessages.add(new ResponseMessageBuilder().code(503).message("Serviço indisponível - indica que algo inesperado aconteceu no lado do servidor (pode ser algo como sobrecarga do servidor, algumas partes do sistema falharam etc.).").build());
        return responseMessages;
    }
}
