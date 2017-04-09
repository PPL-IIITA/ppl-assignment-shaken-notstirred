/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q4;

/**
 *
 * @author Pranjal
 */
public class miser extends boy{
     int budget;
    int costOfGifts;
    int totalHappiness;
            
    void calculateHappiness()
    {
        totalHappiness = budget - costOfGifts;
    }
    
}
