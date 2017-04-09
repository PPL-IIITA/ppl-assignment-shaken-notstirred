/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.*;

/**
 *
 * @author Pranjal
 */
public class Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        FileInputStream cfis = new FileInputStream("couple.txt");
          DataInputStream cdis = new DataInputStream(cfis);
          
          String strn = cdis.readUTF();
          int noOfCouples=Integer.parseInt(strn);
          int kcount = noOfCouples;
          couple[] coupleArray = new couple[noOfCouples];
          
          for(int i=0;i<noOfCouples;i++)
             coupleArray[i]=new couple();
        //  System.out.println(noOfCouples);
          for(int i=0;i<noOfCouples;i++)
          {
              for(int j=0;j<12;j++)
              {
                  String str=cdis.readUTF();
                  if(j==0)
                       coupleArray[i].boy=str;
                  if(j==1)
                       coupleArray[i].girl=str;
                  if(j==2)
                       coupleArray[i].boyid=Integer.parseInt(str);
                  if(j==3)
                       coupleArray[i].girlid=Integer.parseInt(str);
                  if(j==4)
                       coupleArray[i].boyType=Integer.parseInt(str);
                  if(j==5)
                       coupleArray[i].girlType=Integer.parseInt(str);
                  if(j==6)
                       coupleArray[i].boyBud=Integer.parseInt(str);
                  if(j==7)
                       coupleArray[i].girlBud=Integer.parseInt(str);
                  if(j==8)
                       coupleArray[i].boyAtt=Integer.parseInt(str);
                  if(j==9)
                       coupleArray[i].girlAtt=Integer.parseInt(str);
                  if(j==10)
                      coupleArray[i].boyint=Integer.parseInt(str);
                  if(j==11)
                      coupleArray[i].girlint=Integer.parseInt(str);
              }
          }
          
          
         FileInputStream bfis = new FileInputStream("boy.txt");
          DataInputStream bdis = new DataInputStream(bfis);
          
          FileInputStream gfis = new FileInputStream("girl.txt");
          DataInputStream gdis = new DataInputStream(gfis);
        
         String tmp = bdis.readUTF();
         int noOfBoys = Integer.parseInt(tmp);
         boy[] boyArray = new boy[noOfBoys];
         for(int i=0;i<noOfBoys;i++)
             boyArray[i]=new boy();
         
        for(int i=0;i<noOfBoys;i++)
          {
              for(int j=0;j<5;j++)
              {
                  String str = bdis.readUTF();
                //  System.out.println(str);
                  if(j==0)
                     boyArray[i].name=str;
                  
                 else if(j==1)
                      boyArray[i].attractiveness=Integer.parseInt(str);
                  else if(j==2)
                      boyArray[i].budget=Integer.parseInt(str);
                  else if(j==3)
                      boyArray[i].type=Integer.parseInt(str);
                  else if(j==4)
                      boyArray[i].intelligence=Integer.parseInt(str);
              }
          }
          
        tmp = gdis.readUTF();
        int noOfGirls = Integer.parseInt(tmp);
        girl[] girlArray = new girl[noOfGirls];
        for(int i=0;i<noOfGirls;i++)
             girlArray[i]=new girl();
        
          for(int i=0;i<noOfGirls;i++)
          {
              for(int j=0;j<5;j++)
              {
                  String str = gdis.readUTF();
                //  System.out.println(str);
                  if(j==0)
                     girlArray[i].name=str;
                  
                 else if(j==1)
                      girlArray[i].attractiveness=Integer.parseInt(str);
                  else if(j==2)
                      girlArray[i].maintenanceBudget=Integer.parseInt(str);
                  else if(j==3)
                      girlArray[i].type=Integer.parseInt(str);
                  else if(j==4)
                      girlArray[i].intelligence=Integer.parseInt(str);
              }
          }
          
        
        int[] comGirlID = new int[noOfBoys];
        for(int i=0;i<noOfBoys;i++)
            comGirlID[i] = -1;
        
        for(int i=0;i<noOfBoys ; i++)
        {
            for(int j=0;j<noOfCouples;j++)
            {
                if(coupleArray[j].boyid == i)
                    comGirlID[i] = coupleArray[j].girlid;
            }
        }
        
        
        int[] hash = new int[noOfBoys];
        
        for(int i=0;i<noOfBoys;i++)
        {
            hash[i] = comGirlID[i];
        }
        
        
        String input;
        
        //******* Enter method code : \n 1 : Couple Array \n 2 : Sorted Array \n 3 : hash
        int ans=1;
        //***Enter Above**** Enter method code : \n 1 : Couple Array \n 2 : Sorted Array \n 3 : hash
        
        /*System.out.println("Enter method code : \n 1 : Couple Array \n 2 : Sorted Array \n 3 : hash");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        ans = Integer.parseInt(input);*/
        
 //       System.out.println("ans is :"+ans);
        FileOutputStream fos = new FileOutputStream("foundCouple.txt");
          DataOutputStream dos = new DataOutputStream(fos);
 
        if(ans == 1)
        {
            for(int i=0;i<noOfBoys;i++)
            {
                for(int j=0;j<noOfCouples;j++)
                {
                    if(coupleArray[j].boyid == i)
                    {
                       // System.out.println("Couple :"+ coupleArray[j].boy+" & "+coupleArray[j].girl);
                        dos.writeUTF(coupleArray[j].boy);
                        dos.writeUTF(coupleArray[j].girl);
                    }
                }
            }
        }
        else if(ans == 2)
        {
           for(int i=0;i<noOfBoys;i++)
           {
   //            System.out.println(comGirlID[i]);
               if(comGirlID[i] >= 0 )
               {
                   
                   // System.out.println("Couple :"+ boyArray[i].name+" & "+girlArray[comGirlID[i]].name);
                                            dos.writeUTF(boyArray[i].name);
                        dos.writeUTF(girlArray[comGirlID[i]].name);
               }
           }
        }
        else if(ans == 3)
        {
            for(int i=0;i<noOfBoys;i++)
           {
               if(hash[i] != -1)
               {
                  // System.out.println("Couple :"+ boyArray[i].name+" & "+girlArray[hash[i]].name);
                                                               dos.writeUTF(boyArray[i].name);
                        dos.writeUTF(girlArray[hash[i]].name);
               }
           }
        }
          
          
          
    }
    
}
