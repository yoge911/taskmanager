package com.yogeshRokhade.tm.tinyTaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

    @Autowired
    private taskService service;


    @RequestMapping("/tasks")
    public List<taskDto> getAllTasks(){
        return service.findAll();
    }

    @GetMapping("/tasks/{id}")
    public taskDto getTask(@PathVariable String id){
        int taskId = Integer.parseInt(id);
        return service.findOne(taskId);
    }


    @PostMapping("/task")
    public taskDto createTask(@RequestBody taskDto dto){
        return service.create(dto);
    }

    @PutMapping("/task/{id}")
    public taskDto updateTask(@PathVariable String id, @RequestBody taskDto dto){
        int taskId = Integer.parseInt(id);
        return service.update(taskId, dto);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable String id){
        int taskId = Integer.parseInt(id);
        service.delete(taskId);
    }

}
