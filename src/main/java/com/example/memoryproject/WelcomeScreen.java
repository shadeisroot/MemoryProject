package com.example.memoryproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomeScreen extends ImageView {
    private Button btn;
    private Pane introscene;
    private Main mn;

    public WelcomeScreen(Stage stage, Main mm){
        Main mn = new Main();
        introscene = new StackPane();
        introscene.setPrefSize(1250, 1000);
        Button btn = new Button("Start Game");
        btn.setOnAction(e -> {
            mn.gameStart(stage);
        });
        btn.setScaleX(5);
        btn.setScaleY(5);
        introscene.getChildren().add(btn);

        Scene intro = new Scene(introscene);
        stage.setTitle("Welcome");
        stage.setScene(intro);
        stage.show();

    }



}
