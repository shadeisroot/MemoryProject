package com.example.memoryproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EndScreen extends ImageView {


    Image titleScreen = new Image(getClass().getResource("FrontScreen.png").toString());
    Background bG = new Background(new BackgroundImage(titleScreen, null, null, null, null));


    private String tempTries;
    private Label tries = new Label(tempTries);
    private int t;


    public void screenEnd(Stage stage){
        Main mn = new Main();
        Pane endScreen = new Pane();
        endScreen.setPrefSize(1250, 1000);
        Button btn = new Button("Reset Game");
        btn.setOnAction(e -> mn.gameStart(stage));
        endScreen.setBackground(bG);
        btn.setScaleX(5);
        btn.setScaleY(5);
        btn.setLayoutX(625);
        btn.setLayoutY(500);

        endScreen.getChildren().add(btn);
        t = Main.imagesFlipped;
        tempTries = "Moves: "+ t;

        tries.setLayoutX(625);
        tries.setLayoutY(300);
        tries.setScaleX(5);
        tries.setScaleY(5);
        tries.setTextFill(Color.WHITE);
        tries.setText(tempTries);
        endScreen.getChildren().add(tries);

        Scene outtro = new Scene(endScreen);
        stage.setTitle("Welcome");
        stage.setScene(outtro);
        stage.show();
    }


}
