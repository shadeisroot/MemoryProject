package com.example.memoryproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public Pane root;
    public int endGameCounter = 0;
    Comparer comparer = new Comparer();
    ArrayList<Piece> comparedPieces = new ArrayList<>();


    private Stage stage;

    static int imagesFlipped = 0;


    @Override
    public void start(Stage stage) {
        WelcomeScreen ws = new WelcomeScreen(stage);
    }

    public void gameStart(Stage stage) {
        root = new Pane();
        root.setPrefSize(1250, 1000);
        MemeArray.shuffleMemes();
        this.stage = stage;
        EventHandler<MouseEvent> eventHandler = event -> {
            Piece p = (Piece) event.getSource();
            if (!comparedPieces.isEmpty() && comparedPieces.get(0) == p) {
                p.flipBack();
                imagesFlipped++;
                comparedPieces.clear();
                return;
            }
            comparedPieces.add(p);
            p.flip();
            imagesFlipped++;
            comparer.compareMemes(comparedPieces);
        };

        Scene scene = new Scene(root);

        stage.setTitle("MemoryGame");
        stage.setScene(scene);
        buildGame(eventHandler);
        scene.setCamera(new PerspectiveCamera());
        stage.show();

    }
    public void endingTheGame(Stage stage){
        EndScreen es = new EndScreen();
        if(endGameCounter == 10){
            es.screenEnd(stage);
        }


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

    public void remover(Stage stage){
        if (comparer.memesAreSame && comparedPieces.size() == 2 && comparedPieces.get(0).id != comparedPieces.get(1).id) {
            root.getChildren().remove(comparedPieces.get(0));
            root.getChildren().remove(comparedPieces.get(1));
            comparedPieces.clear();
            comparer.memesAreSame = false;
            endGameCounter++;
            endingTheGame(stage);
        } else if (comparedPieces.size() == 2 && !comparer.memesAreSame) {
            comparedPieces.get(0).showBackSide();
            comparedPieces.get(1).showBackSide();
            comparedPieces.clear();
        }
    }

    //Det eneste denne metode gør, er at køre metoden ovenover.. Det er så fucking jank, men det virker, hvis man ikke
    //trykker for hurtigt.
    public void runRemover(){
        remover(this.stage);
    }

    public static void main(String[] args) {
        launch();
    }
}