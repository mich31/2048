/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author michel
 */
public class Grille extends Observable
{
    private Tuile[][] g;
    private int score;
    private int nb_cases;
    
    private Observer obs;
    
    public Grille()
    {
        score = 0;
        nb_cases = 4;
        initGrille();
    }
    
    public void initGrille()
    {
        setG(new Tuile[getNb_cases()][getNb_cases()]);
        for(int i = 0;i<getNb_cases();i++) //ligne
        {
            for(int j = 0;j<getNb_cases();j++) //colonne
            {
                Coordonnees c = new Coordonnees(j,i);
                g[i][j] = new Tuile(c);
            }
        }
    }
    
    public void affichageGrille()
    {
        for(int i = 0;i<4;i++)
        {
            for(int j = 0;j<4;j++)
            {
                System.out.print(g[i][j].getValeur()+" ");
            }
            System.out.println();
        }
    }
    
    // Ajoute aléatoirement une tuile dans la grille
    public void ajoutAleatoireTuile()
    {
        Coordonnees c = getCoordonneesAleatoires();
        g[c.getY()][c.getX()].genereTuile();
    }
    
    // Genere aleatoirement les coordonnees d'une case vide de la grille
    public Coordonnees getCoordonneesAleatoires()
    {
        int x,y;
        boolean b = false;
        do
        {
            x = Tool.monRandom(3, 0);
            y = Tool.monRandom(3, 0);
            
            if(g[y][x].getValeur() == 0)
            {
                b = true;
            }  
        }while(!b);
        
        Coordonnees c = new Coordonnees(x,y);
        return c;
    }
    
    //Vérifie si on peut additionner deux tuiles
    public boolean estEgal(Tuile t1,Tuile t2)
    {
        if((t1.getValeur() == t2.getValeur()) && t1.getDrapeau() && t2.getDrapeau())
        {
            return true;
        }
        else
            return false;
    }
    
    public void addition(Tuile t1,Tuile t2)
    {
        t2.setValeur(0);
        t2.setDrapeau(true);
        
        int n = t1.getValeur();
        n *= 2;
        t1.setValeur(n);
        t1.setDrapeau(false);
        
        score = score + n;
    }
    
    
    public void addObserver(Observer _obs)
    {
        this.obs = _obs;
    }
    
    public void notifyObserver()
    {
        this.obs.update(this, g);
    }
    
    

    /**
     * @param g the g to set
     */
    public void setG(Tuile[][] g) {
        this.g = g;
    }

    /**
     * @return the nb_cases
     */
    public int getNb_cases() {
        return nb_cases;
    }

    /**
     * @param nb_cases the nb_cases to set
     */
    public void setNb_cases(int nb_cases) {
        this.nb_cases = nb_cases;
    }
    
    public enum Direction
    {
        HAUT,
        BAS,
        GAUCHE,
        DROITE
    }
    
    public void deplace(Tuile t1,Tuile t2)
    {
        t1.setValeur(t2.getValeur());
        t1.setDrapeau(t2.getDrapeau());
        t2.setValeur(0);
        t2.setDrapeau(true);
    }
    
    public void init()
    {
        for(int i=0;i<getNb_cases();i++)
        {
            for(int j=0;j<getNb_cases();j++)
            {
                g[i][j].setDrapeau(true);
            }
        }
    }
    
    public boolean mouvement(Direction d)
    {
        boolean mouv = false;
        int k;
        
        switch(d)
        {
            case GAUCHE:
                for(int i=0;i<getNb_cases();i++)
                {
                    for(int j=1;j<getNb_cases();j++)
                    {
                        /*if(estEgal(g[i][j], g[i][j+1]) && g[i][j].getValeur() != 0)
                        {
                            addition(g[i][j],g[i][j+1]);
                            mouv = true;
                        }*/
                        k = j;
                        while(k!=0 && g[i][k].getValeur()!=0 && g[i][k-1].getValeur() == 0)
                        {
                            deplace(g[i][k-1],g[i][k]);
                            k--;
                            mouv = true;
                        }
                        if(k!=0 && estEgal(g[i][k], g[i][k-1]) && g[i][k].getValeur()!=0)
                        {
                            addition(g[i][k-1],g[i][k]);
                            mouv = true;
                        }
                    }
                }
                break;
                
            case DROITE:
                for(int i = 0;i<getNb_cases();i++)
                {
                    for(int j = getNb_cases()-2;j>=0;j--)
                    {
                        k=j;
                        while(k!=getNb_cases()-1 && g[i][k].getValeur()!=0 && g[i][k+1].getValeur() == 0)
                        {
                            deplace(g[i][k+1],g[i][k]);
                            k++;
                            mouv = true;
                        }
                        if(k!=getNb_cases()-1 && estEgal(g[i][k], g[i][k+1]) && g[i][k+1].getValeur()!=0)
                        {
                            addition(g[i][k+1],g[i][k]);
                            mouv = true;
                        }
                    }
                }
                break;
                
            case HAUT:
                for(int j = 0;j<getNb_cases();j++)
                {
                    for(int i = 1;i<getNb_cases();i++)
                    {
                        k=i;
                        while(k!=0 && g[k][j].getValeur()!=0 && g[k-1][j].getValeur() == 0)
                        {
                            deplace(g[k-1][j],g[k][j]);
                            k--;
                            mouv = true;
                        }
                        if(k!=0 && estEgal(g[k-1][j], g[k][j]) && g[k-1][j].getValeur()!=0)
                        {
                            addition(g[k-1][j],g[k][j]);
                            mouv = true;
                        }
                    }
                }
                break;
                
            case BAS:
                for(int j = 0;j<getNb_cases();j++)
                {
                    for(int i = getNb_cases()-2;i>=0;i--)
                    {
                        k=i;
                        while(k!=getNb_cases()-1 && g[k][j].getValeur()!=0 && g[k+1][j].getValeur() == 0)
                        {
                            deplace(g[k+1][j],g[k][j]);
                            k++;
                            mouv = true;
                        }
                        if(k!=getNb_cases()-1 && estEgal(g[k+1][j], g[k][j]) && g[k+1][j].getValeur()!=0)
                        {
                            addition(g[k+1][j],g[k][j]);
                            mouv = true;
                        }
                    }
                }
                break;
        }
        init();
        ajoutAleatoireTuile();
        
        return mouv;
    }
    
    

    /**
     * @return the g
     */
    public Tuile[][] getG() {
        return g;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
