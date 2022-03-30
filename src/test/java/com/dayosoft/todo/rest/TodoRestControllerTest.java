package com.dayosoft.todo.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoRestControllerTest {

    public static final String HTTP_LOCALHOST = "http://localhost:";
    public static final String API_TODO = "/api/todo";

    @LocalServerPort
    private int port;

    @Autowired
    TodoRestController controller;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void givenGetRequest_whenReceived_shouldReturnTodoList() {
        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + API_TODO,
                String.class)).contains("[{\"description\":\"Sample Task\",\"date\":\""
                + LocalDate.now()
                + "\",\"status\":\"Pending\"}]");
    }
}