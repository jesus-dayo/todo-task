package com.dayosoft.todo.rest;

import com.dayosoft.todo.model.Todo;
import com.dayosoft.todo.type.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {

    @GetMapping
    public List<Todo> all() {
        return Collections.singletonList(Todo.builder()
                .date(LocalDate.now())
                .description("Sample Task")
                .status(Status.Pending)
                .build());
    }

}
