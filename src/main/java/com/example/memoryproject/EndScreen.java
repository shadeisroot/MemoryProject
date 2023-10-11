package com.example.memoryproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EndScreen extends ImageView {
    private Button btn;
    private Pane endScreen;
    private Main mn;

    public EndScreen(Stage stage, Main mm){

    }
    public void screenEnd(Stage stage){
        Main mn = new Main();
        endScreen = new StackPane();
        endScreen.setPrefSize(1250, 1000);
        Button btn = new Button("Reset Game");
        btn.setOnAction(e -> {
            mn.gameStart(stage);
        });
        btn.setScaleX(5);
        btn.setScaleY(5);
        endScreen.getChildren().add(btn);

        Scene outtro = new Scene(endScreen);
        stage.setTitle("Welcome");
        stage.setScene(outtro);
        stage.show();
    }


}
