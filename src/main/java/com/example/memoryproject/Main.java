package com.example.memoryproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private Pane root;
    private Piece[][] piecess;
    @Override
    public void start(Stage stage){
        root = new Pane();
        root.setPrefSize(400, 500);


        Scene scene = new Scene(root);

        stage.setTitle("MemoryGame");
        stage.setScene(scene);
        Buildgame();
        stage.show();

    }

    public void Buildgame(){
        piecess = new Piece[20][20];
        int id = 1;
        for (int i=0; i<5; i++)
            for (int j=0; j<4; j++) {
                if (id <= 20) {
                    piecess[j][i] = new Piece(id++, j, i, this);
                    root.getChildren().add(piecess[j][i]);
                }
            }
    }
    public static void main(String[] args) {
        launch();
    }
}