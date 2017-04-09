/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q7;

import java.io.DataOutputStream;

/**
 *
 * @author Pranjal
 */
public class array_implemention extends generic_implementation{
    
    void implementation(int noOfBoys,int noOfCouples,couple coupleArray[])
    {
        for(int i=0;i<noOfBoys;i++)
            {
                for(int j=0;j<noOfCouples;j++)
                {
                    if(coupleArray[j].boyid == i)
                    {
                       // System.out.println("Couple :"+ coupleArray[j].boy+" & "+coupleArray[j].girl);
                       // dos.writeUTF(coupleArray[j].boy);
                        //dos.writeUTF(coupleArray[j].girl);
                    }
                }
            }
    }
    
}
