/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Pranjal
 * Class containing main
 */
public class Q5 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        FileInputStream bfis = new FileInputStream("boy.txt");
          DataInputStream bdis = new DataInputStream(bfis);
          
          FileInputStream gfis = new FileInputStream("girl.txt");
          DataInputStream gdis = new DataInputStream(gfis);
        
         String tmp = bdis.readUTF();
         int noOfBoys = Integer.parseInt(tmp);
         boy[] boyArray = new boy[noOfBoys];
         for(int i=0;i<noOfBoys;i++)
             boyArray[i]=new boy();
         
         //*************Enter the prefered choice of algorithm here********
         
         int choice = 1;
         
         //*************Enter the prefered choice of algorithm above********
         
         
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
          
         for(int i=0;i<noOfBoys;i++)
       {
           for(int j=0;j<noOfBoys-1;j++)
           {
               if(boyArray[j].attractiveness > boyArray[j+1].attractiveness)
               {
                     boy temp;
                     temp=boyArray[j];
                     boyArray[j]=boyArray[j+1];
                     boyArray[j+1]=temp;
               }
           }
       }
         
        for(int i=0;i<noOfGirls;i++)
       {
           for(int j=0;j<noOfGirls-1;j++)
           {
               if(girlArray[j].maintenanceBudget < girlArray[j+1].maintenanceBudget)
               {
                     girl temp;
                     temp=girlArray[j];
                     girlArray[j]=girlArray[j+1];
                     girlArray[j+1]=temp;
               }
           }
       }
        int flag = 0;
       int m = 0;
       int l = 0; 
       
       FileOutputStream fos = new FileOutputStream("alternateCouple.txt");
          DataOutputStream dos = new DataOutputStream(fos);
       
       
        while(true)
        {
                if(flag==0)
                {
                    for(int i=l ; i < noOfGirls ; i++)
                {
                    if(girlArray[i].taken != 1)
                    {
                           for(int j=0;j< noOfBoys;j++)
                            {
                                   if(boyArray[j].taken != 1)
                                   {
                                     if((boyArray[j].budget > girlArray[i].maintenanceBudget) && (girlArray[i].attractiveness > boyArray[j].attractiveness))
                                        {
                                        //   System.out.println(boyArray[j].name + " is in a relationship with AA "+girlArray[i].name);
                                           girlArray[i].taken = 1;
                                           boyArray[j].taken = 1;
                                           
                                            String bind = Integer.toString(j);
                                            String gind = Integer.toString(i);
                                            String btype = Integer.toString(boyArray[j].type);
                                            String gtype = Integer.toString(girlArray[i].type);
                                            String bbud = Integer.toString(boyArray[j].budget);
                                            String gbud = Integer.toString(girlArray[i].maintenanceBudget);
                                            String bint = Integer.toString(boyArray[j].intelligence);
                                            String gint = Integer.toString(girlArray[i].intelligence);
                                            String batt = Integer.toString(boyArray[j].attractiveness);
                                            String gatt = Integer.toString(girlArray[i].attractiveness);

                                            dos.writeUTF(boyArray[j].name);
                                            dos.writeUTF(girlArray[i].name);
                                            dos.writeUTF(bind);
                                            dos.writeUTF(gind);
                                            dos.writeUTF(btype);
                                            dos.writeUTF(gtype);
                                            dos.writeUTF(bbud);
                                            dos.writeUTF(gbud);
                                            dos.writeUTF(batt);
                                            dos.writeUTF(gatt);
                                            dos.writeUTF(bint);
                                            dos.writeUTF(gint);
                                           
                                           
                                           flag = 1;
                                           l++;
                                           break;
                                          
                                        }
                                   }
                                   
                           }
                           if(flag==1)
                                       break;
                    }
                }
                }
                if(flag == 1)
                {
                    for(int i=m ; i < noOfBoys ; i++)
                    {
                        if(boyArray[i].taken != 1)
                        {
                               for(int j=0;j< noOfGirls;j++)
                                {
                                       if(girlArray[j].taken != 1)
                                       {
                                         if((boyArray[j].budget > girlArray[i].maintenanceBudget) && (girlArray[i].attractiveness > boyArray[j].attractiveness))
                                            {
  //                                             System.out.println(boyArray[i].name + " is in a relationship with BB"+girlArray[j].name);
                                               girlArray[j].taken = 1;
                                               boyArray[i].taken = 1;
                                               
                                                String bind = Integer.toString(i);
                                                String gind = Integer.toString(j);
                                                String btype = Integer.toString(boyArray[i].type);
                                                String gtype = Integer.toString(girlArray[j].type);
                                                String bbud = Integer.toString(boyArray[i].budget);
                                                String gbud = Integer.toString(girlArray[j].maintenanceBudget);
                                                String bint = Integer.toString(boyArray[i].intelligence);
                                                String gint = Integer.toString(girlArray[j].intelligence);
                                                String batt = Integer.toString(boyArray[i].attractiveness);
                                                String gatt = Integer.toString(girlArray[j].attractiveness);

                                                dos.writeUTF(boyArray[i].name);
                                                dos.writeUTF(girlArray[j].name);
                                                dos.writeUTF(bind);
                                                dos.writeUTF(gind);
                                                dos.writeUTF(btype);
                                                dos.writeUTF(gtype);
                                                dos.writeUTF(bbud);
                                                dos.writeUTF(gbud);
                                                dos.writeUTF(batt);
                                                dos.writeUTF(gatt);
                                                dos.writeUTF(bint);
                                                dos.writeUTF(gint);
                                               
                                               flag = 0;
                                               m++;
                                               break;
                                            }
                                       }

                               }
                               if(flag==0)
                                           break;
                        }
                    }
                }
  //              System.out.println(l+" "+m);
                if(m == 2 && l == 2)
                {
   //                 System.out.println("oye oye \n");
                    break;
                }
                
        }
          
          
    }
    
}
