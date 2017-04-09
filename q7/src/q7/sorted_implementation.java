/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q7;

/**
 *
 * @author Pranjal
 */
public class sorted_implementation extends generic_implementation{
     void implementation(int noOfBoys,int noOfCouples,couple coupleArray[],int comGirlID[],boy boyArray[],girl girlArray[],int hash[])
    {
         for(int i=0;i<noOfBoys;i++)
           {
               if(hash[i] != -1)
               {
                   System.out.println("Couple :"+ boyArray[i].name+" & "+girlArray[hash[i]].name);
        //                                                       dos.writeUTF(boyArray[i].name);
      //                  dos.writeUTF(girlArray[hash[i]].name);
               }
           }
    }
}
