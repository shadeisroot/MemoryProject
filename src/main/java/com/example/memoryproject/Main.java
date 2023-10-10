package com.example.memoryproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Pane root;
    private Pane introscene;

    private WelcomeScreen ws;

    @Override
    public void start(Stage stage) {
        ws = new WelcomeScreen(stage, this);
    }

    public void gameStart(Stage stage){
        MemeArray.shuffleMemes();
        root = new Pane();
        root.setPrefSize(1250, 1000);
        Scene scene = new Scene(root);
        EventHandler<MouseEvent> eventHandler = event -> {
            Piece p = (Piece) event.getSource();
            p.flip();
        };

        stage.setTitle("MemoryGame");
        stage.setScene(scene);
        buildGame(eventHandler);

        stage.show();
    }
    public void buildGame(EventHandler<MouseEvent> eventHandler) {
        Piece[][] pieces = new Piece[5][4];
        int id = 1;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++) {
                if (id <= 20) {
                    pieces[j][i] = new Piece(id++, j, i, this);
                    root.getChildren().add(pieces[j][i]);
                    pieces[j][i].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                }
            }
    }


    public static void main(String[] args) {
        launch();
    }
}