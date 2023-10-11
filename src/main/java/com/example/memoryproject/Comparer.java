package com.example.memoryproject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Comparer extends Application {

    public boolean memesAreSame = false;
    public  boolean shouldFlipBack = false;

    public Comparer(Main m) {

    }


    public void compareMemes(ArrayList<Piece> pieceArrayList){
        if (pieceArrayList.size() == 2){
            if (Objects.equals(pieceArrayList.get(0).filenameee, pieceArrayList.get(1).filenameee)){
                memesAreSame = true;
                System.out.println("memes are same and should be deleted.");
                shouldFlipBack = false;
            } else {
                memesAreSame = false;
                System.out.println("memes are not same and should not be deleted.");
                shouldFlipBack = true;
            }
        }
    }
    public boolean isMemesSame(){
        return memesAreSame;
    }

    @Override
    public void start(Stage stage) {

    }
}
