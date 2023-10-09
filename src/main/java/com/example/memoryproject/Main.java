package com.example.memoryproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Pane root;
    private Piece[][] piecess;

    @Override
    public void start(Stage stage){
        root = new Pane();
        root.setPrefSize(1250, 1000);


       EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

           @Override
            public void handle(MouseEvent event) {
                Piece p = (Piece) event.getSource();
                p.flip();
            }
        };

        Scene scene = new Scene(root);

        stage.setTitle("MemoryGame");
        stage.setScene(scene);
        buildGame(eventHandler);
        stage.show();

    }

    public void buildGame(EventHandler<MouseEvent> eventHandler) {
        piecess = new Piece[5][4];
        int id = 1;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++) {
                if (id <= 20) {
                    piecess[j][i] = new Piece(id++, j, i, this);
                    root.getChildren().add(piecess[j][i]);
                    piecess[j][i].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                }
            }
    }

    public static void main(String[] args) {
        launch();
    }
}