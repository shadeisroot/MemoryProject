package com.example.memoryproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Piece extends ImageView {
    private Main mn;
    private int id;

    private Image frontside;
    private Image backside;

    private boolean isShuffled = false;

    //private String[] filenames;
    private boolean fs;

    private ArrayList<String> memeNumbers = new ArrayList<>(Arrays.asList("meme1.png", "meme2.png", "meme3.png", "meme4.png",
            "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png", "meme1.png", "meme2.png", "meme3.png",
            "meme4.png", "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png"));

    public Piece(int nr, int x, int y, Main m) {
        shuffleMemes();
        id = nr;

        String filenameee = memeNumbers.get(id - 1);
        String filename = "Backside.jpg";
        frontside = new Image(getClass().getResource(filenameee).toString());
        backside = new Image(getClass().getResource(filename).toString());
        setImage(backside);
        fs = false;
        setX(x * 250);
        setY(y * 250);
        mn = m;
    }

    public void flip() {
        if (fs) {

            setImage(backside);
            fs = false;
        } else {
            setImage(frontside);
            fs = true;
        }
    }

        //self-explanatory.
    private void shuffleMemes() {
        if (isShuffled = false) {
            Collections.shuffle(memeNumbers);
            isShuffled = true;
        }
    }
}
