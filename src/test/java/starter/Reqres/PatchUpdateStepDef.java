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

public class PatchUpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user with valid json with id {int}")
    public void patchUpdateUserWithValidJsonWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/PatchUpdateUser.json");
        reqresAPI.PatchUpdateUser(id, json);
    }

    @When("Send patch update user request")
    public void sendPatchUpdateUserRequest() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate patch update user json schema")
    public void validatePatchUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/PatchUpdateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
