package com.example.memoryproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {
    public Pane root;
    Comparer comparer = new Comparer(this);
    ArrayList<Piece> comparedPieces = new ArrayList<>();


    @Override
    public void start(Stage stage){
        root = new Pane();
        root.setPrefSize(1250, 1000);
        MemeArray.shuffleMemes();

       EventHandler<MouseEvent> eventHandler = event -> {
            Piece p = (Piece) event.getSource();
            p.flip();
            comparedPieces.add(p);
            comparer.clickedMemesFromMain.add(p.filenameee);
            comparer.compareMemes();
            remover();
        };

        Scene scene = new Scene(root);

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

    public void remover(){
        if (comparer.memesAreSame && comparedPieces.size() == 2 && comparedPieces.get(0).id != comparedPieces.get(1).id) {
            root.getChildren().remove(comparedPieces.get(0));
            root.getChildren().remove(comparedPieces.get(1));
            comparedPieces.clear();
            comparer.memesAreSame = false;
        } else if (comparedPieces.size() == 2 && !comparer.memesAreSame) {
            comparedPieces.get(0).flipBack();
            comparedPieces.get(1).flipBack();
            comparedPieces.clear();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}