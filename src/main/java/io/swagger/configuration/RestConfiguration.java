package io.swagger.configuration;

import io.swagger.model.Dataset;
import io.swagger.model.Organization;
import io.swagger.model.Reuse;
import io.swagger.model.Tag;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

    // For newer versions of Spring, check https://stackoverflow.com/questions/24839760/spring-boot-responsebody-doesnt-serialize-entity-id
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        // Here, we specificate those Entities which will have their IDs exposed (for JSON Serialization)
        config.exposeIdsFor(Dataset.class);
        config.exposeIdsFor(Reuse.class);
        config.exposeIdsFor(Tag.class);
        config.exposeIdsFor(Organization.class);
        // TODO Añadir las entidades que se vayan creando/implementando
    }
}
