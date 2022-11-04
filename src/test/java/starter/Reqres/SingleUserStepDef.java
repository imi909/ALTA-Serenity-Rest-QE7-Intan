package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;


import javax.xml.transform.OutputKeys;
import java.io.File;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario Get Single User
    @Given("Get single user with parameter id {int}")
    public void getSingleUserWithParameterIdId(int id) {
        reqresAPI.GetSingleUser(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    //Scenario Get Single User 404 Not Found
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
