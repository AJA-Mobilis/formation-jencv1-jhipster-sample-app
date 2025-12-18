package fr.mobilis.jhipstersampleapp.cucumber;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("fr.mobilis.jhipstersampleapp.cucumber")
class CucumberTest {}
