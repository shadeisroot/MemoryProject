package com.example.memoryproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    int columns = 20;
    int rows = 20;
    boolean debug = true;

    int difficulty = 0;

    @Override
    public void start(Stage stage){
        GridPane window = new GridPane(1000, 800);
        window.addColumn(columns);
        window.addRow(rows);
        window.gridLinesVisibleProperty();



        Scene scene = new Scene(window);
        stage.setTitle("MEMEory Game");
        stage.setScene(scene);
        stage.show();

        Map map = new Map(scene);


    }

    public static void main(String[] args) {
        launch();
    }
}