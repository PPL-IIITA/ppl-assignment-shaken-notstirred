/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Pranjal
 */
public class Q9 {

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
          
          template.method(girlArray,noOfGirls);
          
          /*for(int i=0;i<noOfGirls;i++)
          {
              System.out.println("Name :"+girlArray[i].name+" "+girlArray[i].maintenanceBudget);
          }*/
          int k=0;
          FileOutputStream fos = new FileOutputStream("couple.txt");
          DataOutputStream dos = new DataOutputStream(fos);
        
         for(int i = 0;i < noOfGirls; i++)
        {    
           // System.out.println("girl change");
             if(girlArray[i].takenfc != 1)
             {
                 for(int j=0;j< noOfBoys;j++)
                 {
                 //   System.out.println("Working"+i+j);
                        if(boyArray[j].takenfc != 1)
                        {
                          if(boyArray[j].budget > girlArray[i].maintenanceBudget)
                         {
                    //       System.out.println("Working");
                         //   System.out.println(boyArray[j].name + " is in a relationship with "+girlArray[i].name);
                            boyArray[j].takenfc = 1;
                            girlArray[i].takenfc = 1;
                            k++;
                            break; 

                           }
                        }
                }  
             }
         } 
       //  System.out.println("K is "+k);
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
                          if(boyArray[j].budget > girlArray[i].maintenanceBudget)
                         {
                    //       System.out.println("Working");
                     //       System.out.println(boyArray[j].name + " is in a relationship with "+girlArray[i].name);
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
                            
                           // coupleArray[k].boy=boyArray[j].name;
                           // coupleArray[k].girl=girlArray[i].name;
                           // coupleArray[k].boyid=j;
                            //coupleArray[k].girlid=i;
                            k++;
                            //coupleArray[k].boyType=boyArray[j].type;
                            //coupleArray[k].girlType=girlArray[i].type;
                            
                            
                            break; 

                           }
                        }
                }  
             }
         }
        
         FileInputStream fis = new FileInputStream("gift.txt");
          DataInputStream dis = new DataInputStream(fis);
          
          FileInputStream cfis = new FileInputStream("couple.txt");
          DataInputStream cdis = new DataInputStream(cfis);
          
         String strg = dis.readUTF();
          int noOfGifts=Integer.parseInt(strg);
          
          int[][] gift=new int[noOfGifts][3];
        
        GiftClass[] giftArray = new GiftClass[noOfGifts];
          
          for(int i=0;i<noOfGifts;i++)
             giftArray[i]=new GiftClass();

          for(int i=0;i<noOfGifts;i++)
          {
              for(int j=0;j<7;j++)
              {
                  String str=dis.readUTF();
                  
                  if(j==0)
                      giftArray[i].type=Integer.parseInt(str);
                  else if(j==1)
                      giftArray[i].price=Integer.parseInt(str);
                  else if(j==2)
                      giftArray[i].value=Integer.parseInt(str);
                  else if(j==3)
                      giftArray[i].luxuryRating=Integer.parseInt(str);
                  else if(j==4)
                      giftArray[i].difficulty=Integer.parseInt(str);
                  else if(j==5)
                      giftArray[i].utilityValue=Integer.parseInt(str);
                  else if(j==6)
                      giftArray[i].utilityClass=Integer.parseInt(str);
                  
              }
          }
          
          strn = cdis.readUTF();
          int noOfCouples=Integer.parseInt(strn);
          int kcount = noOfCouples;
          couple[] coupleArray = new couple[noOfCouples];
         // System.out.println("No. Of Couples :"+noOfCouples);
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
          
     template.method(giftArray,noOfGifts);
     
          
     k=0;
    for(int i=0;i<noOfCouples;i++)
    {
        int cost=0;
        int luxuryvalue=0;
        int luxtot=0;
        
        if(coupleArray[i].boyType==0)
        {
            while(cost + giftArray[k].price < coupleArray[i].girlBud)
            {
                coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[k]; 
                cost+=giftArray[k].price;
                luxtot+=giftArray[k].value;
                if(giftArray[k].type == 2)
                    luxuryvalue+=giftArray[k].value;
                k++;
                coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
            }
            if(cost + giftArray[k].price < coupleArray[i].boyBud)
            {
            coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[k];
            cost+=giftArray[k].price;
            luxtot+=giftArray[k].value;
                k++;
                coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
                
            }
            
        }
        
        else if(coupleArray[i].boyType==1)
        {
            while(cost + giftArray[k].price < coupleArray[i].girlBud)
            {
                coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[k]; 
                cost+=giftArray[k].price;
                luxtot+=giftArray[k].value;
                if(giftArray[k].type == 2)
                    luxuryvalue+=giftArray[k].value;
                k++;
                coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
            }
        }
        
        else if(coupleArray[i].boyType==2)
        {
            while(cost + giftArray[k].price < coupleArray[i].girlBud)
            {
                coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[k]; 
                cost+=giftArray[k].price;
                luxtot+=giftArray[k].value;
                if(giftArray[k].type == 2)
                    luxuryvalue+=giftArray[k].value;
                k++;
                coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
            }
            if(cost + giftArray[k].price < coupleArray[i].boyBud)
            {
            coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[k];
            cost+=giftArray[k].price;
            luxtot+=giftArray[k].value;
                k++;
                coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
                
            }
                
            int x = k;
            
            while(true)
            {
                if(giftArray[x].type != 2)
                    x++;
                else
                    break;     
            }
            coupleArray[i].gifts[coupleArray[i].giftIndex]=giftArray[x]; 
               cost+=giftArray[x].price;
               luxuryvalue+=giftArray[x].value;
               
              for(int d=x;d<noOfGifts-1;d++)
              {
                  giftArray[d]=giftArray[d+1];
              }
              noOfGifts=noOfGifts-1;
                
         }
        coupleArray[i].totcost=cost;
        coupleArray[i].luxvalue=luxuryvalue;
        coupleArray[i].happinessGirl();
        coupleArray[i].happinessBoy();
        double tothappiness=coupleArray[i].happinessGirl() + coupleArray[i].happinessBoy();
        coupleArray[i].tothap=tothappiness;
        coupleArray[i].comp=coupleArray[i].compatibility();
        
    }
          
          
         
    }
    
}
