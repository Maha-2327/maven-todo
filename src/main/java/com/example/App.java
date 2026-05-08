package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("To-Do List");

        TextField taskField = new TextField();
        taskField.setPromptText("Enter task");

        Button addButton = new Button("Add");

        ListView<String> taskList = new ListView<>();

        Button deleteButton = new Button("Delete Selected");

        addButton.setOnAction(e -> {
            String task = taskField.getText();

            if (!task.isEmpty()) {
                taskList.getItems().add(task);
                taskField.clear();
            }
        });

        deleteButton.setOnAction(e -> {
            String selectedTask = taskList.getSelectionModel().getSelectedItem();

            if (selectedTask != null) {
                taskList.getItems().remove(selectedTask);
            }
        });

        HBox inputBox = new HBox(10, taskField, addButton);

        VBox root = new VBox(15,
                title,
                inputBox,
                taskList,
                deleteButton
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("JavaFX To-Do App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}