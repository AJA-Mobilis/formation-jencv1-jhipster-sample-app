package fr.mobilis.jhipstersampleapp.cucumber;

import fr.mobilis.jhipstersampleapp.IntegrationTest;
import fr.mobilis.jhipstersampleapp.security.AuthoritiesConstants;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@CucumberContextConfiguration
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser(authorities = AuthoritiesConstants.ADMIN)
public class CucumberTestContextConfiguration {}
