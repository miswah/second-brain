package io.miswah.secondbrain.dto.request;

import io.miswah.secondbrain.constants.Priority;
import lombok.Data;

@Data
public class TasksRequestDTO {
    private String title;
    private Priority priority;
}
