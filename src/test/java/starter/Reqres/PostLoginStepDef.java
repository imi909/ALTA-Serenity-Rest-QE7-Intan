package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;


import javax.xml.transform.OutputKeys;
import java.io.File;

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario Login Successful
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLogin.json");
        reqresAPI.PostLogin(json);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    //Scenario Login Unsuccessful
    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostLoginUnsuccessful.json");
        reqresAPI.PostLoginUnsuccessful(json);
    }
}
