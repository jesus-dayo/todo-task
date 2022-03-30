package com.dayosoft.todo.rest;

import com.dayosoft.todo.model.Todo;
import com.dayosoft.todo.repository.TodoRepository;
import com.dayosoft.todo.type.Status;
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
    TodoRepository todoRepository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void givenUserId_whenGetTodoList_shouldReturnTodoList() {
        final String userId = "u12345";
        final LocalDate today = LocalDate.now();
        todoRepository.save(Todo.builder().userId(userId)
                .date(today)
                .description("Sample Task").status(Status.Pending).build());

        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + API_TODO + "/" + userId,
                String.class)).contains("[{\"id\":1,\"description\":\"Sample Task\",\"date\":\""
                + today
                + "\",\"status\":\"Pending\",\"userId\":\"u12345\"}]");
    }
}