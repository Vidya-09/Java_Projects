package com.todo.exception;

@SuppressWarnings("serial")
public class TaskNotFoundException extends RuntimeException{
	public TaskNotFoundException(Long id) {
        super("Task with ID " + id + " not found.");
    }
}
