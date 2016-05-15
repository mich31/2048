/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu_2048;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modele.*;

/**
 *
 * @author michel
 */
public class Jeu extends Application 
{
    private Grille obj_g;
    
    public Jeu()
    {
        this.obj_g = new Grille();
        obj_g.ajoutAleatoireTuile();
        obj_g.ajoutAleatoireTuile();
        obj_g.ajoutAleatoireTuile();
        obj_g.ajoutAleatoireTuile();
        obj_g.ajoutAleatoireTuile();
        obj_g.ajoutAleatoireTuile();
        obj_g.affichageGrille();
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        Group root = new Group();
        // Scene(parent,width,height,color)
        Scene scene = new Scene(root, 500, 500,Color.WHITE);
        primaryStage.setResizable(false);
        
        Rectangle grille = new Rectangle();
        grille.setX(180);
        grille.setY(180);
        grille.setWidth(300); //largeur
        grille.setHeight(300); //hauteur
        grille.setFill(Color.LIGHTSLATEGREY);
        grille.setStroke(Color.AQUAMARINE); //couleur des contours
        grille.setStrokeWidth(5); // épaisseur des contours
        grille.setArcHeight(30);
        grille.setArcWidth(20);
        
        root.getChildren().add(grille); // On ajoute la grille
    
        Image nb0 = new Image("img/0.png");
        Image nb2 = new Image("img/2.png");
        Image nb4 = new Image("img/4.png");
        Image nb8 = new Image("img/8.png");
        
        for(int i = 0;i<obj_g.getNb_cases();i++)
        {
            for(int j = 0;j<obj_g.getNb_cases();j++)
            {
                Rectangle case_grille = new Rectangle();
                case_grille.setX(195+(j*10)+(j*60));
                case_grille.setY(195+(i*10)+(i*60));
                case_grille.setWidth(60);
                case_grille.setHeight(60);
                
                switch(obj_g.getG()[i][j].getValeur())
                {
                    case 0:
                        case_grille.setFill(new ImagePattern(nb0));
                        break;
                    case 2:
                        case_grille.setFill(new ImagePattern(nb2));
                        break;
                    case 4:
                        case_grille.setFill(new ImagePattern(nb4));
                        break;
                    default:
                        case_grille.setFill(new ImagePattern(nb8));
                        break;
                }
                
                root.getChildren().add(case_grille);
            }
        }
        
        
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
    }
    
}
