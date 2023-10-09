package com.example.memoryproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Collections;
import java.util.List;
public class Piece extends ImageView {
    private Main mn;
    private int id;

    private Image frontside;
    private Image backside;

    private String[] filenames;
    private boolean fs;
    public Piece(int nr ,int x, int y, Main m) {
        id = nr;
        filenames = new String[]{"meme1.png", "meme2.png", "meme3.png", "meme4.png", "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png","meme1.png", "meme2.png", "meme3.png", "meme4.png", "meme5.png", "meme6.png", "meme7.png", "meme8.png", "meme9.png", "meme10.png"};
        Collections.shuffle(filenames);
        String filenameee = filenames[id-1];
        String filename = "Backside.jpg";
        frontside = new Image(getClass().getResource(filenameee).toString());
        backside = new Image(getClass().getResource(filename).toString());
        setImage(frontside);
        fs = true;
        setX(x * 250);
        setY(y * 250);
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
