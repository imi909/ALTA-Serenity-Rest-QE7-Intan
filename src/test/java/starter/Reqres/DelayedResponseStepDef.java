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

public class DelayedResponseStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get delayed response with page {int}")
    public void getDelayedResponseWithDelayPage(int page) {
        reqresAPI.GetDelayedResponse(page);
    }

    @When("Send delayed response")
    public void sendDelayedResponse() {
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

//    @And("Response body should be {int}")
//    public void responseBodyShouldBeDelay(int delay) {
//        SerenityRest.then().body(ReqresResponses.DELAY, equalTo(delay));
//    }

    @And("Response body should be {int}")
    public void responseBodyShouldBePage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
}
