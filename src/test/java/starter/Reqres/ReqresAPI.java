package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";

    public static String GET_LIST_USERS = URL + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/user/{id}";
    public static String DELETE_USER = URL + "/api/user/{id}";

    //Tugas
    public static String GET_SINGLE_USER = URL + "/api/user/{id}";
    public static String GET_LIST_RESOURCE = URL + "/api/unknown?page={page}";
    public static String GET_SINGLE_RESOURCE = URL + "/api/unknown/{id}";
    public static String PATCH_UPDATE_USER = URL + "/api/user/{id}";
    public static String POST_REGISTER = URL + "/api/register";
    public static String POST_LOGIN = URL + "/api/login";
    public static String GET_DELAYED_RESPONSE = URL + "/api/users?delay={delay}";

    //Scenario Get List User
    @Step("Get list users")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Scenario Post Create User
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Put Update User
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                    .pathParam("id", id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    //Scenario Delete User
    @Step("Delete user")
    public void DeleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Scenario Get Single User
    @Step("Get single user")
    public void GetSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Scenario Get List Resource
    @Step("Get list resource")
    public void GetListResource(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Scenario Get Single Resource
    @Step("Get single resource")
    public void GetSingleResource(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Scenario Patch Update User
    @Step("Patch update user")
    public void PatchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Post Register
    @Step("Post Register")
    public void PostRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Post Register Unsuccessful
    @Step("Post Register Unsuccessful")
    public void PostRegisterUnsuccesful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Post Login
    @Step("Post Login")
    public void PostLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Post Login Unsuccessful
    @Step("Post Login Unsuccessful")
    public void PostLoginUnsuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Scenario Get Delayed Response
   @Step("Get Delayed Response")
    public void GetDelayedResponse(int delay){
        SerenityRest.given()
                .pathParam("delay", delay);
   }
}
