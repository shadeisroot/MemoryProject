package com.example.memoryproject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemeArray extends Application {
    static boolean isShuffled = false;
    private static ArrayList<String> memeNumbers = new ArrayList<>(Arrays.asList("meme1.png", "meme2.png", "meme3.png", "meme4.png",
            "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png",
            "meme1.png", "meme2.png", "meme3.png", "meme4.png", "meme5.png", "meme6.png", "meme7.png",
            "meme8.png", "meme9.png", "meme10.png"));

    public static void shuffleMemes() {
        if (!isShuffled) {
            Collections.shuffle(memeNumbers);
            isShuffled = true;
        }
    }

    public static List<String> getMemes(){
        return memeNumbers;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
