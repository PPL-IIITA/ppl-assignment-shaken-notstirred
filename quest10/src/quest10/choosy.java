/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.quest10;

/**
 *
 * @author Pranjal
 */
public class choosy extends girl {
     int girlhap;
    int totcost;
    int girlBud;
    int luxvalue;
    
    void calculateHappiness()
    {
        girlhap=(int)Math.log10(totcost-girlBud+(2*luxvalue));
    }   
}
