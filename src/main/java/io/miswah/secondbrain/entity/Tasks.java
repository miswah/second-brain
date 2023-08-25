package io.miswah.secondbrain.entity;

import io.miswah.secondbrain.constants.Priority;
import io.miswah.secondbrain.constants.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "status")
    private TaskStatus status = TaskStatus.YET_TO_PICK;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "finished_at")
    private LocalDateTime finishedAt = null;


    public Tasks(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
    }
}
