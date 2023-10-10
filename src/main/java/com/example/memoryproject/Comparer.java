package com.example.memoryproject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Comparer extends Application {



    public ArrayList<String> clickedMemesFromMain = new ArrayList<>();
    public boolean memesAreSame = false;
    public  boolean shouldFlipBack = false;
    private String pieceOneFile;
    private String pieceTwoFile;

    public Comparer(Main m) {

    }

    public static void main(String[] args) {

    }



    public void compareMemes(){
        if (clickedMemesFromMain.size() == 2){
            if (Objects.equals(clickedMemesFromMain.get(0), clickedMemesFromMain.get(1))){
                pieceOneFile = clickedMemesFromMain.get(0);
                pieceTwoFile = clickedMemesFromMain.get(1);
                memesAreSame = true;
                System.out.println("memes are same and should be deleted.");
                shouldFlipBack = false;
                clickedMemesFromMain.clear();
            } else {
                memesAreSame = false;
                System.out.println("memes are not same and should not be deleted.");
                clickedMemesFromMain.clear();
                shouldFlipBack = true;
                System.out.println(shouldFlipBack);
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
