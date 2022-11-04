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

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario Register Successful
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegister.json");
        reqresAPI.PostRegister(json);
    }

    @When("Send post register user")
    public void sendPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    //    @And("Validate post register json schema")
//    public void validatePostRegisterJsonSchema() {
//        File json = new File(ReqresAPI.JSON_SCHEMA + "/RegisterJsonSchema");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    //Scenario Register Unsuccessful
    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PostRegisterUnsuccessful.json");
        reqresAPI.PostRegisterUnsuccesful(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }




}
