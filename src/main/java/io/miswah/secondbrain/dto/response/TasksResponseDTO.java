package io.miswah.secondbrain.dto.response;

import io.miswah.secondbrain.constants.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksResponseDTO {
    private int id;
    private String title;
    private Priority priority;
}
