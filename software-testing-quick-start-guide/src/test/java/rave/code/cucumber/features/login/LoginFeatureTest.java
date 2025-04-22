package rave.code.cucumber.features.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:rave/code/cucumber/features/login.feature")
public class LoginFeatureTest {
}
