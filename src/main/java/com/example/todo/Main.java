package com.example.todo;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        AppUI ui = new AppUI(manager);
        ui.show();
    }
}
