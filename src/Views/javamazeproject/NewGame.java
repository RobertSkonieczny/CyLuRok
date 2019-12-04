/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamazeproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author luke_
 */
public class NewGame extends JavaMazeProject {
   
    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

    public Scene wanker;
    
    
    
    public NewGame() {

      final Menu menu1 = new Menu("Save Progress...");
      MenuItem showUp = new MenuItem("Select Me!");
      menu1.getItems().addAll(showUp);
      final Menu menu2 = new Menu("Quit Game...");
      MenuBar menuBar = new MenuBar();
      menuBar.getMenus().addAll(menu1,menu2);
      BorderPane root = new BorderPane();
      VBox everything = new VBox();
      
        
        
       rootPane = new BorderPane();
       int rows = 15;
       int columns = 15;
        
        GridPane easyGrid = new GridPane();
        easyGrid.getStyleClass().add("gridCSS");
        
        for(int i = 0; i < columns; i++){
            ColumnConstraints column = new ColumnConstraints(40);
            easyGrid.getColumnConstraints().add(column);
        }
        
        for(int i = 0; i < rows; i++){
            RowConstraints row = new RowConstraints(40);
            easyGrid.getRowConstraints().add(row);
        }
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                Pane easyPane = new Pane();
                easyPane.setOnMouseReleased(e -> {
                    easyPane.getChildren().add(Anims.getAtoms(1));
                });
                easyPane.getStyleClass().add("gridCSS-cell");
                if (i==0){
                    easyPane.getStyleClass().add("first-column");
                }
                if (j==0){
                    easyPane.getStyleClass().add("first-row");
                }
               easyGrid.add(easyPane,i,j);
            }
        }
        
        easyGrid.setAlignment(Pos.CENTER);
        everything.getChildren().add(root);
        root.setTop(menuBar);
        everything.getChildren().add(easyGrid);
        Scene easyScene = new Scene(everything, (columns * 40) +100, (rows * 40) +100, Color.WHITE);
        
        easyScene.getStylesheets().add("picpack/gridCSS.css");
        
        wanker = easyScene;

        

    }

    public Pane getRootPane() {
      return rootPane ;
    }
    
    
    
    public static class Anims {
        public static Node getAtoms(final int number){
            Circle circle = new Circle (20, 20f, 7);
            circle.setFill(Color.GREEN);
            Group group = new Group();
            group.getChildren().add(circle);
            return group;
        }
    }

    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
