package com.dayosoft.todo.rest;

import com.dayosoft.todo.model.Todo;
import com.dayosoft.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoRepository todoRepository;

    @GetMapping("/{userId}")
    public List<Todo> all(@PathVariable String userId) {
        return todoRepository.findByUserId(userId);
    }

}
