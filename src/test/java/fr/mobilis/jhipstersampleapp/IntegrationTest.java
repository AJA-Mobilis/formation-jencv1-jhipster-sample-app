package fr.mobilis.jhipstersampleapp;

import fr.mobilis.jhipstersampleapp.config.AsyncSyncConfiguration;
import fr.mobilis.jhipstersampleapp.config.EmbeddedSQL;
import fr.mobilis.jhipstersampleapp.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JhipsterSampleApplicationApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedSQL
public @interface IntegrationTest {}
