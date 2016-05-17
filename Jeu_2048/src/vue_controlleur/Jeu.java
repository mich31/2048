/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue_controlleur;

import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
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
public class Jeu extends Application implements Observer
{
    private Grille obj_g;
    private Stage st;
    
    public Jeu()
    {
        this.obj_g = new Grille();
        obj_g.ajoutAleatoireTuile();
        obj_g.addObserver(this);
        
        obj_g.affichageGrille();
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        this.st=primaryStage;
        Group root = new Group();
        // Scene(parent,width,height,color)
        Scene scene = new Scene(root, 500, 500,Color.WHITE);
        primaryStage.setResizable(false);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
           public void handle(final KeyEvent k)
           {
               
               switch(k.getCode())
               {
                   case UP:
                      obj_g.mouvement(Grille.Direction.HAUT);
                      obj_g.notifyObserver();
                      break;
                   case DOWN:
                       obj_g.mouvement(Grille.Direction.BAS);
                       obj_g.notifyObserver();
                       break;
                   case LEFT:
                       obj_g.mouvement(Grille.Direction.GAUCHE);
                       obj_g.notifyObserver();
                       break;
                   case RIGHT:
                       obj_g.mouvement(Grille.Direction.DROITE);
                       obj_g.notifyObserver();
                       break;
                   default:
                       break;
               }
           }
       });
        
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
        Image nb16 = new Image("img/16.png");
        Image nb32 = new Image("img/32.png");
        Image nb64 = new Image("img/64.png");
        Image nb128 = new Image("img/128.png");
        Image nb256 = new Image("img/256.png");
        Image nb512 = new Image("img/512.png");
        Image nb1024 = new Image("img/1024.png");
        Image nb2048 = new Image("img/2048.png");
        
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
                    case 8:
                        case_grille.setFill(new ImagePattern(nb8));
                        break;
                    case 16:
                        case_grille.setFill(new ImagePattern(nb16));
                        break;
                    case 32:
                        case_grille.setFill(new ImagePattern(nb32));
                        break;
                    case 64:
                        case_grille.setFill(new ImagePattern(nb64));
                        break;
                    case 128:
                        case_grille.setFill(new ImagePattern(nb128));
                        break;
                    case 256:
                        case_grille.setFill(new ImagePattern(nb256));
                        break;
                    case 512:
                        case_grille.setFill(new ImagePattern(nb512));
                        break;
                    case 1024:
                        case_grille.setFill(new ImagePattern(nb1024));
                        break;
                    case 2048:
                        case_grille.setFill(new ImagePattern(nb2048));
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

    @Override
    public void update(Observable o, Object arg) 
    {
        
        start(st);
    }
    
}
