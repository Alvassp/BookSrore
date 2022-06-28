package apisteps;

import object.AccountReq;
import pages.User;

import static io.restassured.RestAssured.given;

public class AccountSteps {
    public boolean login(User user){
        Specifications.installSpecifications(Specifications.requestSpecification(), Specifications.responseSpecification200());
        AccountReq accountReq = new AccountReq(user.getLogin(), user.getPassword());
        return given()
                .body(accountReq)
                .when()
                .post("/Account/v1/Authorized")
                .then().log().all()
                .extract().as(Boolean.class);
    }
}
