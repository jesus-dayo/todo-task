package com.dayosoft.todo.model;

import com.dayosoft.todo.type.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Todo {

    private String description;
    private LocalDate date;
    private Status status;

}
