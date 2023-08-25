package io.miswah.secondbrain.constants;

public enum Priority {
    URGENT("URGENT"),
    BACKLOG("BACKLOG"),
    UNDER_PROCESS("UNDER_PROCESS");

    String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
