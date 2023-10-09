package com.example.memoryproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Piece extends ImageView {
    private Main mn;
    private int id;

    private Image frontside;
    private Image backside;
    private boolean fs;
    public Piece(int nr ,int x, int y, Main m){
        id = nr;
        String filnavn = "b" + id + ".jpg";
        String filename = "Backside.jpg";
        frontside = new Image(getClass().getResource(filnavn).toString());
        backside = new Image(getClass().getResource(filename).toString());
        setImage(frontside);
        fs = true;
        setX(x*200);
        setY(y*200);
        mn = m;
    }
    public void flip(){
        if(fs){

            setImage(backside);
            fs = false;
        }
        else{
            setImage(frontside);
        }
    }
}
