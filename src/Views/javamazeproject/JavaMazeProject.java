/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamazeproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
 import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.io.*;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author luke_
 */
public class JavaMazeProject extends Application {
    
    
    @Override
    public void start(Stage theStage) throws Exception {
         
        final double CANVAS_WIDTH = 550;
        final double CANVAS_HEIGHT = 550;
         
        final Image titleScreen = new Image( "picpack/meh.jpg" ); //title screen image
        final Image resumeGameButton = new Image("picpack/ResumeGame.PNG"); //the resume button image
        final Image newGameButton = new Image("picpack/NewGame.PNG"); //the new game button image
 
        final ImageView setScreenImg = new ImageView();
        setScreenImg.setImage(titleScreen); //set the image of the title screen
        
        setScreenImg.setFitWidth(550);
        setScreenImg.setFitHeight(550);
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
 
        Text titleFont = new Text();
        titleFont.setEffect(ds);
        titleFont.setCache(true);
        titleFont.setX(10.0f);
        titleFont.setY(270.0f);
        titleFont.setFill(Color.YELLOW);
        titleFont.setText("The Maze!(That will ruin your life)");
        titleFont.setFont(Font.font(null, FontWeight.BOLD, 32));
       
        final Button resumeBtn  = new Button();
        final ImageView resumeBtnNode = new ImageView(); 
        resumeBtnNode.setFitHeight(69);
        resumeBtnNode.setFitWidth(142);
        resumeBtn.setOnAction(e -> {
        resumeGame game = new resumeGame();
        theStage.getScene().setRoot(game.getRootPane());
        });
         
        final Button newBtn = new Button();
        final ImageView newBtnNode = new ImageView(); 
        newBtnNode.setFitHeight(69);
        newBtnNode.setFitWidth(142);
        newBtn.setOnAction(e -> {
            NewGame game = new NewGame();
            theStage.setScene(game.wanker);
        });
        
         
        resumeBtnNode.setImage(resumeGameButton); //set the image of the resume button
        newBtnNode.setImage(newGameButton); //set the image of the new game button
         
        resumeBtn.setGraphic(resumeBtnNode);
        resumeBtn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY))); //this is to make the button background transparent
         
        newBtn.setGraphic(newBtnNode);
        newBtn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
         
        /*
         * create the container of  buttons
         */
        final VBox buttonContainer = new VBox(1);
        buttonContainer.setAlignment(Pos.TOP_CENTER);
        Insets buttonContainerPadding = new Insets(220, 1, 1, 1);
        buttonContainer.setPadding(buttonContainerPadding);
        buttonContainer.getChildren().addAll(resumeBtn,newBtn);
         
        theStage.setTitle("CyLuRok Maze Game!!");
        theStage.getIcons().add(titleScreen); //stage icon
 
        StackPane root = new StackPane();
        StackPane.setAlignment(titleFont, Pos.TOP_CENTER);
         
        root.getChildren().addAll(setScreenImg,titleFont ,buttonContainer); //add the title screen and button container to the stackpane
        Scene theScene = new Scene( root, CANVAS_WIDTH, CANVAS_HEIGHT, Color.CHOCOLATE );
        theStage.setScene( theScene );
        theStage.show(); 
        
 
    } 
 
    public static void main(String[] args) {
        launch(args);
    }
 
}