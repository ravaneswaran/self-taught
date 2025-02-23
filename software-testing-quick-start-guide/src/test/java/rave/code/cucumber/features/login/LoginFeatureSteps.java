package rave.code.cucumber.features.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginFeatureSteps {

    @Given("User lands on the sign in page")
    public void user_lands_on_the_sign_in_page() {
        System.out.println("***************************");
        Assert.assertTrue(0==0);
    }

    @When("the user keys in the username field his\\/her email id")
    public void the_user_keys_in_the_username_field_his_her_email_id() {
        Assert.assertTrue(0==0);
    }

    @When("the user keys in the password field his\\/her password")
    public void the_user_keys_in_the_password_field_his_her_password() {
        Assert.assertTrue(0==0);
    }

    @Then("the system should evaluate the user credentials")
    public void the_system_should_evaluate_the_user_credentials() {
        Assert.assertTrue(0==0);
    }

    @Then("when the user credentials found valid")
    public void when_the_user_credentials_found_valid() {
        Assert.assertTrue(0==0);
    }

    @Then("the user should be taken to the home page.")
    public void the_user_should_be_taken_to_the_home_page() {
        Assert.assertTrue(0==0);
    }
}
