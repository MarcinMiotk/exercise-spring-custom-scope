package pl.wind.humpback.app.scopesample;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@ComponentScan(basePackageClasses = DialogConfiguration.class)
public class DialogConfiguration {

    @Bean
    public CustomScopeConfigurer customScope() {

        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        Map<String, Object> scopes = new HashMap<>();
        scopes.put("dialog", new DialogScope());
        configurer.setScopes(scopes);

        return configurer;
    }
}
