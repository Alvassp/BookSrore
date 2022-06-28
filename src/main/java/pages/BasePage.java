package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    public final String BASE_MENU_XPATH = "//div[@class='left-pannel']" +
            "//div[@class = 'element-group' and contains(.,'%s')]";

    @Step("Navigate by menu to :{menu}")
    public void leftSideMenuNavigation(String menu){
        var pathList = menu.split(":");
        SelenideElement leftSideElement = $x(String.format(BASE_MENU_XPATH, pathList[0]));
        if(leftSideElement.lastChild().scrollIntoView(true).getAttribute("class").contains("show")){
            leftSideElement.findAll("li").filter(Condition.text(pathList[1])).first().click();
        }else {
            leftSideElement.click();
            leftSideElement.findAll("li").filter(Condition.text(pathList[1])).first().click();
        }
    }

    public void setTextToInput(SelenideElement element, String text){
        element.click();
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(text);
    }
}
