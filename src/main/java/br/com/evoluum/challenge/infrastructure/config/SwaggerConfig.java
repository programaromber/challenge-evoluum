package br.com.evoluum.challenge.infrastructure.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;

import br.com.evoluum.challenge.domain.dto.ResponseDTO;
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

	private final TypeResolver typeResolver;

	@Autowired
    public SwaggerConfig(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages())
				.securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.evoluum.challenge.api.controller"))
				.paths(PathSelectors.any())
				.build().additionalModels(typeResolver.resolve(ResponseDTO.class))
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Project for Challenge Evoluum").description(
				"API for querying states and countys of Brazil, <a href='https://servicodados.ibge.gov.br/api/docs/localidades'>click here</a> to enter source page. ")
				.termsOfServiceUrl("https://github.com/rafasall/challenge-evoluum").contact(new Contact("Rafael Salles",
						"https://github.com/rafasall", "rafaelsalles.sistemas@gmail.com.com.brm"))
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

	private List<ResponseMessage> getCustomizedResponseMessages() {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(200).message("Sucess").build());
		responseMessages.add(new ResponseMessageBuilder().code(400).message("Incorect request").build());
		responseMessages.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
		responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbiden").build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("Not found").build());
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Internal server error").build());
		return responseMessages;
	}
}
