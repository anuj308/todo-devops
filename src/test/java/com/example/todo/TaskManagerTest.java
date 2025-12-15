package com.example.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

import main.java.com.example.todo.TaskManager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @Test
    @Order(1)
    void addTask_increasesSize() {
        manager.addTask("Task 1");
        assertEquals(1, manager.size());
    }

    @Test
    @Order(2)
    void addTask_trimsAndStores() {
        manager.addTask("  hello  ");
        List<String> tasks = manager.getTasks();
        assertEquals("hello", tasks.get(0));
    }

    @Test
    @Order(3)
    void removeTask_returnsRemoved() {
        manager.addTask("A");
        manager.addTask("B");
        String removed = manager.removeTask(0);
        assertEquals("A", removed);
        assertEquals(1, manager.size());
    }

    @Test
    @Order(4)
    void getTasks_unmodifiable() {
        manager.addTask("X");
        List<String> tasks = manager.getTasks();
        assertThrows(UnsupportedOperationException.class, () -> tasks.add("Y"));
    }

    @Test
    @Order(5)
    void invalidAdd_throws() {
        assertThrows(IllegalArgumentException.class, () -> manager.addTask(" "));
        assertThrows(IllegalArgumentException.class, () -> manager.addTask(null));
    }

    @Test
    @Order(6)
    void invalidRemove_throws() {
        assertThrows(IndexOutOfBoundsException.class, () -> manager.removeTask(0));
    }
}
