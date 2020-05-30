package br.com.evoluum.challenge.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(SwaggerProperties.PREFIX)
public class SwaggerProperties {
    public static final String PREFIX = "app.swagger";

    private Boolean enabled = true;

    private String browsingBasePath = "/api/swagger";

    private String invokingBasePath = "";
    
	public SwaggerProperties() {
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getBrowsingBasePath() {
		return browsingBasePath;
	}

	public void setBrowsingBasePath(String browsingBasePath) {
		this.browsingBasePath = browsingBasePath;
	}

	public String getInvokingBasePath() {
		return invokingBasePath;
	}

	public void setInvokingBasePath(String invokingBasePath) {
		this.invokingBasePath = invokingBasePath;
	}
    
    
}