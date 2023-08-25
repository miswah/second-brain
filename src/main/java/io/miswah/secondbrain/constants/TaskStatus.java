package io.miswah.secondbrain.constants;

public enum TaskStatus {
    ON_GOING("ON_GOING"),
    COMPLETED("COMPLETED"),
    YET_TO_PICK("YET_TO_PICK");

    String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
}
