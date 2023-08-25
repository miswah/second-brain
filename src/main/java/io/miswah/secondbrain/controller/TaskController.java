package io.miswah.secondbrain.controller;

import io.miswah.secondbrain.dto.request.TasksRequestDTO;
import io.miswah.secondbrain.dto.response.SuccessResponseDTO;
import io.miswah.secondbrain.dto.response.TasksResponseDTO;
import io.miswah.secondbrain.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TaskController extends BaseController {
    private final TasksService tasksService;

    @Autowired
    public TaskController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public List<TasksResponseDTO> getTasks() {
        return tasksService.getTasks();
    }

    @PostMapping("")
    public SuccessResponseDTO createNewTasks(@RequestBody TasksRequestDTO tasksRequestDTO) {
        return tasksService.createNewTasks(tasksRequestDTO);
    }
}
