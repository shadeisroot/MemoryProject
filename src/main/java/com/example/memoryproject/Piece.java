package com.example.memoryproject;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;


public class Piece extends ImageView {
    private Main mn;
    public int id;

    private Image frontside;
    private Image backside;
    public  String filenameee;


    private boolean fs;

    public ArrayList<String> clickedMemes = new ArrayList<>(Arrays.asList());
    public ArrayList<String> gottenMemes;

    public Piece(int nr, int x, int y, Main m) {
        //shuffleMemes();
        id = nr;

        gottenMemes = (ArrayList<String>) MemeArray.getMemes();
        filenameee = gottenMemes.get(id - 1);
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
            clickedMemes.remove(this.filenameee);
            setImage(backside);
            fs = false;
        } else {
            setImage(frontside);
            fs = true;
            clickedMemes.add(this.filenameee);
        }
    }

    public void flipBack(){
        if (fs) {
            setImage(backside);
            fs = false;
        }
    }
}
