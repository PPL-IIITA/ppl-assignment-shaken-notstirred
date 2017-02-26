package src.q1;
import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.io.FileInputStream;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package q1;
/**
 *
 * @author Pranjal
 */
public class Q1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        
      //  int noOfBoys = 4;
       // int noOfGirls = 2;
        
        
//        for(int i =0;i<3;i++) boy[i] = new boy();
        
        
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
     
      /* boyArray[0] = new boy();
        boyArray[0].attractiveness = 9;
        boyArray[0].name = "khush";
        boyArray[0].budget = 3000;
        
        boyArray[1] = new boy();
        boyArray[1].attractiveness = 15;
        boyArray[1].name = "akash";
        boyArray[1].budget = 20000;
        
        boyArray[2] = new boy();
        boyArray[2].attractiveness = 12;
        boyArray[2].name = "arpit";
        boyArray[2].budget = 3000;
        
        boyArray[3] = new boy();
        boyArray[3].attractiveness = 10;
        boyArray[3].name = "patil";
        boyArray[3].budget = 10000;
        
        girlArray[0] = new girl();
        girlArray[0].criterion=1;
        girlArray[0].attractiveness = 60;
        girlArray[0].name = "lucy";
        girlArray[0].maintenanceBudget =12000;
        
        girlArray[1] = new girl();
        girlArray[1].criterion=1;
        girlArray[1].attractiveness = 50;
        girlArray[1].name = "scarlet";
        girlArray[1].maintenanceBudget =25000;*/
     
        /*for(int i=0;i<4;i++)
          {
              System.out.println("le"+boyArray[i].name+"le"+boyArray[i].attractiveness+"le"+boyArray[i].budget);
       //       System.out.println(boyArray[i].name);
          }
          
          for(int i=0;i<2;i++)
          {
              System.out.println("le"+girlArray[i].name+"le"+girlArray[i].attractiveness+"le"+girlArray[i].maintenanceBudget);
       //       System.out.println(boyArray[i].name);
          }*/
        
        couples coupleArray[]= new couples[20];
        for(int i=0;i<20;i++)
            coupleArray[i]=new couples();
        int k=-1;
        
        FileOutputStream fos = new FileOutputStream("couple.txt");
          DataOutputStream dos = new DataOutputStream(fos);
        
         for(int i = 0;i < noOfGirls; i++)
        {    
           // System.out.println("girl change");
             if(girlArray[i].taken != 1)
             {
                 for(int j=0;j< noOfBoys;j++)
                 {
                 //   System.out.println("Working"+i+j);
                        if(boyArray[j].taken != 1)
                        {
                          if((boyArray[j].budget > girlArray[i].maintenanceBudget) && (girlArray[i].attractiveness > boyArray[j].attractiveness))
                         {
                    //       System.out.println("Working");
                     //       System.out.println(boyArray[j].name + " is in a relationship with "+girlArray[i].name);
                            boyArray[j].takenfc = 1;
                            girlArray[i].takenfc = 1;
                            k++;
                            break; 

                           }
                        }
                }  
             }
         } 
         String strn = Integer.toString(k);
         dos.writeUTF(strn); 
        for(int i = 0;i < noOfGirls; i++)
        {    
           // System.out.println("girl change");
             if(girlArray[i].taken != 1)
             {
                 for(int j=0;j< noOfBoys;j++)
                 {
                 //   System.out.println("Working"+i+j);
                        if(boyArray[j].taken != 1)
                        {
                          if((boyArray[j].budget > girlArray[i].maintenanceBudget) && (girlArray[i].attractiveness > boyArray[j].attractiveness))
                         {
                    //       System.out.println("Working");
                            System.out.println(boyArray[j].name + " is in a relationship with "+girlArray[i].name);
                            boyArray[j].taken = 1;
                            girlArray[i].taken = 1;
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
                            
                            coupleArray[k].boy=boyArray[j].name;
                            coupleArray[k].girl=girlArray[i].name;
                            coupleArray[k].boyid=j;
                            coupleArray[k].girlid=i;
                            k++;
                            //coupleArray[k].boyType=boyArray[j].type;
                            //coupleArray[k].girlType=girlArray[i].type;
                            
                            
                            break; 

                           }
                        }
                }  
             }
         }
        String end=Integer.toString(-1);
       dos.writeUTF(end);
        
        }
        
    
        
    }
    
