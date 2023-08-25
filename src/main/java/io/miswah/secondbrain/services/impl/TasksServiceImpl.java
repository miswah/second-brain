package io.miswah.secondbrain.services.impl;

import io.miswah.secondbrain.dto.request.TasksRequestDTO;
import io.miswah.secondbrain.dto.response.SuccessResponseDTO;
import io.miswah.secondbrain.dto.response.TasksResponseDTO;
import io.miswah.secondbrain.entity.Tasks;
import io.miswah.secondbrain.exceptions.EntityNotFoundException;
import io.miswah.secondbrain.repository.TasksRepository;
import io.miswah.secondbrain.services.TasksService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TasksResponseDTO> getTasks() {
        List<Tasks> tasks = tasksRepository.findAll();
        List<TasksResponseDTO> tasksResponseDTOS = new ArrayList<>();
        for (Tasks task : tasks) {
            tasksResponseDTOS.add(modelMapper.map(task, TasksResponseDTO.class));
        }
        return tasksResponseDTOS;
    }

    @Override
    public TasksResponseDTO getTask(int id) {
        Optional<Tasks> task = tasksRepository.findById(id);

        if (task.isEmpty()) {
            throw new EntityNotFoundException(HttpStatus.NOT_FOUND, "No Task With that id exists in database");
        }

        TasksResponseDTO tasksResponseDTO = modelMapper.map(task, TasksResponseDTO.class);
        return tasksResponseDTO;
    }

    @Override
    public SuccessResponseDTO createNewTasks(TasksRequestDTO tasksRequestDTO) {
//        modelMapper.typeMap(TasksRequestDTO.class, Tasks.class).addMappings(mapper -> {
//            mapper.skip(Tasks::setId);
//        });
        Tasks task = modelMapper.map(tasksRequestDTO, Tasks.class);
        tasksRepository.save(task);
        return new SuccessResponseDTO(HttpStatus.CREATED, "New Tasks Added", task);
    }

}
