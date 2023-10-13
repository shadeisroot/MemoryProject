package com.example.memoryproject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemeArray extends Application {
    static boolean isShuffled = false;


//this is where all the images is stored. in a arraylist
    private static ArrayList<String> memeNumbers = new ArrayList<>(Arrays.asList("meme1.png", "meme2.png", "meme3.png", "meme4.png",
            "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png",
            "meme1.png", "meme2.png", "meme3.png", "meme4.png", "meme5.png", "meme6.png", "meme7.png",
            "meme8.png", "meme9.png", "meme10.png"));


//checks if isshuffled is == true
    public static void shuffleMemes() {
        if (!isShuffled) {
            Collections.shuffle(memeNumbers);
            isShuffled = true;
        }
    }//End of shufflefMemes

    public static List<String> getMemes(){
        return memeNumbers;
    }//End of getMemes

    public static void main(String[] args) {
        launch(args);
    }//End of main

    @Override
    public void start(Stage primaryStage) {

    }//End of start
}//End of Class
