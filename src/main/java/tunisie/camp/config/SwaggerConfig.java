package tunisie.camp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    private Info infoAPI() {
        return new Info()
                .title("Tunisie Camp API")
                .description("API documentation for the Tunisie Camp application.")
                .version("1.0.0")
                .contact(new Contact()
                        .name("Gaith")
                        .email("mohamedgaithb@gmail.com")
                        .url("https://www.tunisiecamp.com"));
    }
}
