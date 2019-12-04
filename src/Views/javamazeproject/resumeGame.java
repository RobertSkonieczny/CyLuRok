/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamazeproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author luke_
 */
public class resumeGame extends JavaMazeProject {
    
  
    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

    public resumeGame() {

        rootPane = new BorderPane();
        

        // build UI, register event handlers, etc etc

    }

    public Pane getRootPane() {
        return rootPane ;
    }

    // other methods you may need to access, etc...


    public static void main(String[] args) {
        launch(args);
    }
    
}
