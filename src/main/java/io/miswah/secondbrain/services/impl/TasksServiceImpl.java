package io.miswah.secondbrain.services.impl;

import io.miswah.secondbrain.dto.request.TasksRequestDTO;
import io.miswah.secondbrain.dto.response.SuccessResponseDTO;
import io.miswah.secondbrain.dto.response.TasksResponseDTO;
import io.miswah.secondbrain.entity.Tasks;
import io.miswah.secondbrain.repository.TasksRepository;
import io.miswah.secondbrain.services.TasksService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public SuccessResponseDTO createNewTasks(TasksRequestDTO tasksRequestDTO) {
//        modelMapper.typeMap(TasksRequestDTO.class, Tasks.class).addMappings(mapper -> {
//            mapper.skip(Tasks::setId);
//        });
        Tasks task = modelMapper.map(tasksRequestDTO, Tasks.class);
        tasksRepository.save(task);
        return new SuccessResponseDTO(HttpStatus.CREATED, "New Tasks Added", task);
    }
}
