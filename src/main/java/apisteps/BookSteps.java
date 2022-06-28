package apisteps;

import object.BooksReq;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookSteps {
    public List<BooksReq> getBooks(){
        Specifications.installSpecifications(Specifications.requestSpecification(), Specifications.responseSpecification200());
        List<BooksReq> listOfBooks = given().when()
                .get("/BookStore/v1/Books")
                .then().log().all()
                .extract().body().jsonPath().getList("books", BooksReq.class);
        return listOfBooks;
    }

    public BooksReq getBookByISBN(String ISBN){
        Specifications.installSpecifications(Specifications.requestSpecification(), Specifications.responseSpecification200());
        BooksReq listOfBooks = given().when()
                .get(String.format("/BookStore/v1/Book?ISBN=%s", ISBN))
                .then().log().all()
                .extract().as(BooksReq.class);
        return listOfBooks;
    }
}
