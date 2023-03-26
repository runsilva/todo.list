package com.todolist.controller;

import com.todolist.model.Task;
import com.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class taskController {

    public TaskService taskService;

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask (@RequestBody Task task ) {
        log.info ("Criando uma nova Tarefa com as informações [{}]", task);
        return taskService.createTask(task);

    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTask () {

        log.info ("Listando Todas as Tarefa");
        return taskService.listAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById (@PathVariable(value = "id") Long id){

        log.info ("Listando uma Tarefa com id [{}]", id);
        return taskService.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskById (@PathVariable(value = "id") Long id, @RequestBody Task task){
        log.info ("Atualizando uma Tarefa com id [{}]", id);
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTaskById (@PathVariable(value = "id") Long id){
        log.info ("Deletando uma Tarefa com com id [{}]", id);
        return taskService.deleteTaskbyId(id);
    }
}
