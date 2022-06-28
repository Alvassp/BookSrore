package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.HashMap;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    private final String BASE_LOGIN_XPATH = "//div[@class = 'login-wrapper']";

    @Step("Login to system login:{login} - password:{password}")
    public void loginByNameAndPassword(User user) {
        fillLoginAndPassword(user.getLogin(), user.getPassword());
        clickOnLogin();
    }

    @Step("Sign up to system")
    public void signUp(HashMap<String, String> signUpData) {
        $(byId("newUser")).click();
        signUpData.keySet().forEach(x -> {
            setTextToInput($x(String.format("//input[@placeholder = '%s']", x)), signUpData.get(x));
        });
        $(byId("register")).shouldBe(Condition.enabled, Duration.ofSeconds(5)).click();

    }

    public void fillLoginAndPassword(String login, String password) {
        setTextToInput($(byId("userName")), login);
        setTextToInput($(byId("password")), password);
    }

    public void clickOnLogin() {
        $(byId("login"));
    }
}
