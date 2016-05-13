/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author p1212374
 */
public class Tool 
{
    
    static int monRandom(int max,int min)
    {
        int res;
        int n = (int)(Math.random() * 10);
                
        if(n % 2 == 0)
            res = min + (int)(Math.random() * (max - min)) + 1;
        else
            res = min + (int)(Math.random() * (max - min)) - 1;
        
        if(res > max)
            res--;
        else if(res < min)
            res++;
        
        return res;
    }
    
}
