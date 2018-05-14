package com.yogeshRokhade.tm.tinyTaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;/**/
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class taskService {

    @Autowired
    private TaskRepository repository;
    private AtomicInteger nextId = new AtomicInteger();

    public List<taskDto> findAll(){

       return repository.findAll().stream()
        .map(entity -> new taskDto(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getStatus(), entity.getPriority()))
        .collect(Collectors.toList());

    }

    @Transactional
    public taskDto create(taskDto task) {
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setDescription(task.getDescription());
        newTask.setPriority(task.getPriority());
        Task savedTask = repository.save(newTask);
        return new taskDto(savedTask.getTitle(), savedTask.getDescription(), savedTask.getPriority(), savedTask.getStatus());
    }

    @Transactional
    public taskDto findOne(Integer id){
        Task entity = findOneSafe(id);
        return new taskDto(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getStatus(), entity.getPriority());

    }

    private Task findOneSafe(Integer id) {
        Task task = repository.getOne(id);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID : " + id + "not found.");
        } else {
            return task;
        }
    }

    @Transactional
    public taskDto update(Integer id, taskDto task) {
        Task entity = findOneSafe(id);
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setStatus(task.getStatus());
        entity.setDescription(task.getDescription());
        entity.setPriority(task.getPriority());
        return new taskDto(entity.getTitle(), entity.getDescription(), entity.getPriority(), entity.getStatus());
    }

    @Transactional
    public void delete(Integer id) {
        Task task = findOneSafe(id);
        repository.delete(task);
    }



}
