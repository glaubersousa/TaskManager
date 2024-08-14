package com.isystem.taskmanagerapi.repository;

import com.isystem.taskmanagerapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {



}
