package com.dayosoft.todo.repository;

import com.dayosoft.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByUserId(String userId);

}
