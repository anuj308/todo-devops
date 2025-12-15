package com.example.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private final List<String> tasks = new ArrayList<>();

    public synchronized void addTask(String task) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");
        if (task.trim().isEmpty()) throw new IllegalArgumentException("Task cannot be empty");
        tasks.add(task.trim());
    }

    public synchronized String removeTask(int index) {
        if (index < 0 || index >= tasks.size()) throw new IndexOutOfBoundsException("Invalid index");
        return tasks.remove(index);
    }

    public synchronized List<String> getTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks));
    }

    public synchronized int size() {
        return tasks.size();
    }

    public synchronized void clearAll() {
        tasks.clear();
    }
}
