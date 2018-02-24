package com.example;

import org.json.JSONException;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class FunctionalWebApplicationTests {

    private final WebTestClient webTestClient =
            WebTestClient.bindToRouterFunction(FunctionalWebApplication.getRouter()).build();

    public FunctionalWebApplicationTests() throws JSONException {
    }

    @Test
    public void indexPage_WhenRequested_SaysHello() {
        webTestClient.get().uri("/").exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .isEqualTo("Hello");
    }



}
