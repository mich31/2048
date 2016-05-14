/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu_2048;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.*;

/**
 *
 * @author michel
 */
public class Jeu_2048 extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 500, 500,Color.WHITESMOKE);
        
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
        Grille g = new Grille();
        g.ajoutAleatoireTuile();
        g.ajoutAleatoireTuile();
        g.ajoutAleatoireTuile();
        g.ajoutAleatoireTuile();
        g.affichageGrille();
    }
    
}
