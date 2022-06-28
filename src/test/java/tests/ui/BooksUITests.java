package tests.ui;

import apisteps.BookSteps;
import helpers.StringsHelper;
import helpers.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.User;
import tests.BaseTest;
import java.util.HashMap;


@Listeners({TestListener.class})
@Epic("Book store")
@Feature("Feature_BookStore")
public class BooksUITests extends BaseTest {

    @BeforeMethod
    public void startBrowser(){
        init();
    }


    @Test(description = "Login to bookstore")
    public void BookTest_1() {
        loginPage.leftSideMenuNavigation("Book Store Application:Login");
        loginPage.loginByNameAndPassword(User.Alex);
    }

    @Test(description = "Sign up new User")
    public void BookTest_2() {
        HashMap<String, String> signupData = new HashMap<>() {
            {
                put("First Name", StringsHelper.getRandomLetterString(10));
                put("Last Name", StringsHelper.getRandomLetterString(10));
                put("UserName", StringsHelper.getRandomLetterString(10));
                put("Password", StringsHelper.getRandomLetterString(10));
            }
        };
        loginPage.leftSideMenuNavigation("Book Store Application:Login");
        loginPage.signUp(signupData);
    }

    @Test(description = "Get list of book by author")
    public void BookTest_3() {
        BookSteps bookSteps = new BookSteps();
        BookStorePage bookStorePage = new BookStorePage();
        String author = bookSteps.getBookByISBN("9781449325862").getAuthor();
        loginPage.leftSideMenuNavigation("Book Store Application:Book Store");
        bookStorePage.serchBooksByParam(author);
        Assert.assertTrue(bookStorePage.getListOfBookTitle().size() > 0);
    }
}
