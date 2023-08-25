package io.miswah.secondbrain.services;

import io.miswah.secondbrain.dto.request.TasksRequestDTO;
import io.miswah.secondbrain.dto.response.SuccessResponseDTO;
import io.miswah.secondbrain.dto.response.TasksResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasksService {

    List<TasksResponseDTO> getTasks();

    SuccessResponseDTO createNewTasks(TasksRequestDTO tasksRequestDTO);

    TasksResponseDTO getTask(int id);

    SuccessResponseDTO updatedTask(TasksRequestDTO tasksRequestDTO, int id);
}
