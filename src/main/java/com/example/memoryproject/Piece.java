package com.example.memoryproject;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;


public class Piece extends ImageView {
    private Main mn;
    public int id;

    private Image frontside;
    private Image backside;
    public  String filenameee;

    public static boolean readyForAction = true;

    public boolean fs;
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
            showBackSide();
        } else {
            showFrontSide();
        }
    }

    public void showFrontSide(){

        readyForAction = false;
        RotateTransition rotatorHideBack = new RotateTransition(Duration.millis(300), this);
        rotatorHideBack.setAxis(Rotate.Y_AXIS);
        rotatorHideBack.setFromAngle(0);
        rotatorHideBack.setToAngle(90);
        rotatorHideBack.setInterpolator(Interpolator.LINEAR);
        rotatorHideBack.setCycleCount(1);
        rotatorHideBack.setOnFinished(e -> setImage(frontside));

        RotateTransition rotatorShowFront = new RotateTransition(Duration.millis(300), this);
        rotatorShowFront.setAxis(Rotate.Y_AXIS);
        rotatorShowFront.setFromAngle(90);
        rotatorShowFront.setToAngle(0);
        rotatorShowFront.setInterpolator(Interpolator.LINEAR);
        rotatorShowFront.setCycleCount(1);

        SequentialTransition showFrontSequence = new SequentialTransition(rotatorHideBack, rotatorShowFront);
        showFrontSequence.play();
        showFrontSequence.setOnFinished(e -> readyForAction = true);
        showFrontSequence.setOnFinished(e -> fs = true);
        showFrontSequence.setOnFinished(e -> mn.runRemover());
    }

    public void showBackSide(){

        readyForAction = false;
        RotateTransition rotatorHideFront = new RotateTransition(Duration.millis(300), this);
        rotatorHideFront.setAxis(Rotate.Y_AXIS);
        rotatorHideFront.setFromAngle(0);
        rotatorHideFront.setToAngle(90);
        rotatorHideFront.setInterpolator(Interpolator.LINEAR);
        rotatorHideFront.setCycleCount(1);
        rotatorHideFront.setOnFinished(e -> setImage(backside));

        RotateTransition rotatorShowBack = new RotateTransition(Duration.millis(300), this);
        rotatorShowBack.setAxis(Rotate.Y_AXIS);
        rotatorShowBack.setFromAngle(90);
        rotatorShowBack.setToAngle(0);
        rotatorShowBack.setInterpolator(Interpolator.LINEAR);
        rotatorShowBack.setCycleCount(1);

        SequentialTransition showBackSequence = new SequentialTransition(rotatorHideFront, rotatorShowBack);
        showBackSequence.play();

        showBackSequence.setOnFinished(e -> readyForAction = true);
        showBackSequence.setOnFinished(e -> fs = false);
        showBackSequence.setOnFinished(e -> mn.runRemover());
    }
}
