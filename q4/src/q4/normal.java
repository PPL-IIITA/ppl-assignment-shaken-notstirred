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
public class normal extends girl{
    int totcost;
    int girlBud;
    int girlhap;
    
    void calculateHappiness()
    {
        girlhap=(int)(Math.pow(2.73,(totcost-girlBud)))%20;
    }
}
