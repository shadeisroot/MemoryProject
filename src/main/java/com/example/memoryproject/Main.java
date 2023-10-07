package com.example.memoryproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Pane root;
    private Piece[][] piecess;
    @Override

    public void start(Stage stage){
        root = new Pane();
        root.setPrefSize(400, 400);


        Scene scene = new Scene(root);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        Buildgame();
        stage.show();

    }

    public void Buildgame(){
        piecess = new Piece[16][16];
        int id = 1;
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++) {
                if (id <= 16) {      // Der er kun 15 brikker - den 16. er det tomme felt.
                    // Brikkerne gemmes i et 2D array og sættes på scenen
                    piecess[j][i] = new Piece(id++, j, i, this);
                    root.getChildren().add(piecess[j][i]);
                }
            }

    }

    public static void main(String[] args) {
        launch();
    }
}