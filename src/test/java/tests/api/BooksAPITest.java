package tests.api;

import apisteps.AccountSteps;
import apisteps.BookSteps;
import helpers.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.User;

import java.util.stream.Collectors;

@Listeners({TestListener.class})
@Epic("Book store")
@Feature("API")
public class BooksAPITest {
    private final static BookSteps BOOK_STEPS= new BookSteps();
    private final static AccountSteps ACCOUNT_STEPS = new AccountSteps();
    @Test(description = "Get book collection")
    public void books_1(){
        var books = BOOK_STEPS.getBooks();
        Assert.assertTrue(books.stream().filter(x -> x.getTitle().contains("Git Pocket Guide"))
                .collect(Collectors.toList()).size() > 0);
    }

    @Test(description = "Search book by ISBN")
    public void book_2(){
        Assert.assertTrue(BOOK_STEPS.getBookByISBN("9781449325862").getAuthor().equals("Richard E. Silverman"));
    }

    @Test(description = "Login to system")
    public void login_1(){
        Assert.assertFalse(ACCOUNT_STEPS.login(User.Alex));
    }

}
