package com.solinum.mower;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderApiTests {
    @LocalServerPort
    private Integer port;
    @MockBean
    private OrderService orderService;

    @Test
    public void order() {
        // @formatter:off
            given()
                .port(port)
           .when()
                .contentType(ContentType.JSON)
                .body("{\"mower\":{\"posAbs\":1,\"posOrd\":2,\"dir\":\"N\"},\"orders\":\"GAGAGAGAA\",\"grass\":{\"topRight\":5,\"lowerLeft\":5}}")
                .post("/order")
           .then()
              .statusCode(200);
        // @formatter:on
    }
}
