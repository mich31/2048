/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author michel
 */
public class Tuile 
{
    private int valeur; // Valeur de la tuile
    private boolean drapeau; // True par défaut
    private Coordonnees coord;
    
    public Tuile(Coordonnees c)
    {
        this.valeur = 0;
        this.drapeau = true;
        this.coord = c;
    }
    
    // Genere une tuile de valeur 2 ou 4
    public void genereTuile()
    {
        int n = Tool.monRandom(10,0);
        if(n%4 == 0)
        {
            this.valeur = 4;
        }
        else
        {
            this.valeur = 2;
        }
        //System.out.println(this.valeur);
    }

    
    /**
     * @return the valeur
     */
    public int getValeur() 
    {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(int valeur) 
    {
        this.valeur = valeur;
    }

    /**
     * @return the drapeau
     */
    public boolean getDrapeau() {
        return drapeau;
    }

    /**
     * @param drapeau the drapeau to set
     */
    public void setDrapeau(boolean drapeau) {
        this.drapeau = drapeau;
    }

    /**
     * @return the coord
     */
    public Coordonnees getCoord() {
        return coord;
    }

    /**
     * @param coord the coord to set
     */
    public void setCoord(Coordonnees coord) {
        this.coord = coord;
    }
}
