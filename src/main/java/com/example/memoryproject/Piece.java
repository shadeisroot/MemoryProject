package com.example.memoryproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece extends ImageView {
    private Main mn;
    private int id;


    public Piece(int nr ,int x, int y, Main m){
        id = nr;
        String filnavn = "Badger" + ".jpg";
        setImage(new Image(getClass().getResource(filnavn).toString()));
        setX(x*100);
        setY(y*100);
        mn = m;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

}
