package com.example.todo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AppUI {
    private final TaskManager manager;
    private final JFrame frame;
    private final DefaultListModel<String> listModel;
    private final JList<String> taskList;
    private final JTextField inputField;

    public AppUI(TaskManager manager) {
        this.manager = manager;
        frame = new JFrame("To-Do App (DevOps Project)");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        inputField = new JTextField(20);
        initialize();
    }

    private void initialize() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new BorderLayout(8,8));

        // Top: input + add button
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("New Task:"));
        top.add(inputField);
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(this::onAdd);
        top.add(addBtn);

        // Center: list in scroll pane
        JScrollPane scroll = new JScrollPane(taskList);

        // Right: buttons (remove, clear)
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        JButton removeBtn = new JButton("Remove Selected");
        removeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeBtn.addActionListener(this::onRemove);
        JButton clearBtn = new JButton("Clear All");
        clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearBtn.addActionListener(e -> {
            manager.clearAll();
            refreshList();
        });
        right.add(Box.createVerticalStrut(10));
        right.add(removeBtn);
        right.add(Box.createVerticalStrut(8));
        right.add(clearBtn);

        frame.add(top, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(right, BorderLayout.EAST);

        refreshList();
        frame.setLocationRelativeTo(null);
    }

    private void onAdd(ActionEvent e) {
        String text = inputField.getText();
        try {
            manager.addTask(text);
            inputField.setText("");
            refreshList();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onRemove(ActionEvent e) {
        int idx = taskList.getSelectedIndex();
        if (idx == -1) {
            JOptionPane.showMessageDialog(frame, "Select a task first", "No Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            manager.removeTask(idx);
            refreshList();
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(frame, "Failed to remove task", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshList() {
        List<String> tasks = manager.getTasks();
        listModel.clear();
        tasks.forEach(listModel::addElement);
    }

    public void show() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}
