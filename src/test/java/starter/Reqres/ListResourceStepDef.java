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

public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario Get List Resource
    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPagePage(int page) {
        reqresAPI.GetListResource(page);
    }

    @When("Send get list resource")
    public void sendGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Validate list resource json schema")
    public void validateListResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/GetListResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Get Single Resource
    @Given("Get single resource with parameter id {int}")
    public void getSingleResourceWithParameterIdId(int id) {
        reqresAPI.GetSingleResource(id);
    }

    @When("Send get single resource")
    public void sendGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }


    @And("Validate single resource json schema")
    public void validateSingleResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/GetSingleResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
