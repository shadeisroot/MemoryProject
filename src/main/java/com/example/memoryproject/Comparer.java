package com.example.memoryproject;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;

public class Comparer extends Application {

    public boolean memesAreSame = false;


    public Comparer() {

    }




    public void compareMemes(ArrayList<Piece> pieceArrayList){

        if (pieceArrayList.size() == 2){
            memesAreSame = Objects.equals(pieceArrayList.get(0).filenameee, pieceArrayList.get(1).filenameee);
        }
    }





    @Override
    public void start(Stage stage) {

    }
}
