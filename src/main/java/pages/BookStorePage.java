package pages;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class BookStorePage extends BasePage{
    public void serchBooksByParam(String param){
        setTextToInput($(byId("searchBox")), param);
    }

    public List<String> getListOfBookTitle(){
        return $$x("//div[@class = 'rt-tbody']//a").texts();
    }
}
