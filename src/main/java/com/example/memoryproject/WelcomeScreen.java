package com.example.memoryproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomeScreen extends ImageView {

    private Pane introscene;


    Image titleScreen = new Image(getClass().getResource("FrontScreen.png").toString());
    Background bG = new Background(new BackgroundImage(titleScreen, null, null, null, null));

    public WelcomeScreen(Stage stage){
        Main mn = new Main();
        introscene = new StackPane();
        introscene.setPrefSize(1250, 1000);
        Button btn = new Button("Start Game");
        btn.setOnAction(e -> mn.gameStart(stage));
        btn.setScaleX(5);
        btn.setScaleY(5);
        introscene.setBackground(bG);
        introscene.getChildren().add(btn);

        Scene intro = new Scene(introscene);
        stage.setTitle("Welcome");
        stage.setScene(intro);
        stage.show();

    }
}
