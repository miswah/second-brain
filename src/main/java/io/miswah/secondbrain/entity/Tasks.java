package io.miswah.secondbrain.entity;

import io.miswah.secondbrain.constants.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public Tasks(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
    }
}
