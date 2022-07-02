package com.biraj.backbase.movie.movieapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MovieApiControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private static final String BASE_URL = "http://localhost:";

    //@Test
    void givenProductId_GetProductEndpoint_ShouldReturnProduct(){
        String url = BASE_URL.concat((String.valueOf(port)).concat("/v1/api/"));
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()));
    }
}
