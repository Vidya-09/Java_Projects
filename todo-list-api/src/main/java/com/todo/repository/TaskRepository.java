package com.todo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByCompleted(boolean completed);

}

