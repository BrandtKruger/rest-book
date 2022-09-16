package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON;
import static io.netty.handler.codec.http.HttpHeaderValues.TEXT_PLAIN;
import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when()
                .get("/api/books")
          .then()
             .statusCode(200)
             .body("size()", is(2));
    }

    @Test
    public void shouldCountAllBooks(){
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void shouldGetABook(){
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 1)
                .when()
                .get("api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Test1"))
                .body("author", is("Auth1"))
                .body("yearOffPublication", is(2010))
                .body("genre", is("IT"));
    }

}