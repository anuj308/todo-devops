package com.example.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    void testAddTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Buy milk");
        assertEquals(1, manager.size());
    }

    @Test
    void testRemoveTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Task 1");
        manager.addTask("Task 2");
        manager.removeTask(0);
        assertEquals(1, manager.size());
    }

    @Test
    void testEmptyTaskNotAllowed() {
        TaskManager manager = new TaskManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addTask(" "));
    }
}
