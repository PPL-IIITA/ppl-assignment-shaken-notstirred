/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Pranjal
 */
public class Q3 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
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
        
       for(int i=0;i<noOfGifts;i++)
       {
           for(int j=0;j<noOfGifts-1;j++)
           {
               if(giftArray[j].value > giftArray[j+1].value)
               {
                  // System.out.println("comparing"+gift[j][1]+"&"+gift[j+1][1]);
                     GiftClass temp;
                     temp=giftArray[j];
                     giftArray[j]=giftArray[j+1];
                     giftArray[j+1]=temp;
               }
           }
       }
       
       for(int i=0;i<noOfGifts;i++)
       {
           for(int j=0;j<noOfGifts-1;j++)
           {
               if(giftArray[j].price>giftArray[j+1].price)
               {
                     GiftClass temp;
                     temp=giftArray[j];
                     giftArray[j]=giftArray[j+1];
                     giftArray[j+1]=temp;
               }
           }
       }
        
     int k=0;
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

    for(int i=0;i<noOfCouples;i++)
       {
           for(int j=0;j<noOfCouples-1;j++)
           {
               if(coupleArray[j].tothap < coupleArray[j+1].tothap)
               {
                     couple temp;
                     temp=coupleArray[j];
                     coupleArray[j]=coupleArray[j+1];
                     coupleArray[j+1]=temp;
               }
           }
       }
    
   
    
          FileOutputStream opfos = new FileOutputStream("answer.txt");
          DataOutputStream opdos = new DataOutputStream(opfos);
          
          opdos.writeUTF("The k happiest couples are \n");
          for(int i=0;i<kcount;i++)
          {
      //        System.out.println(i);
              String str = coupleArray[i].boy;
              opdos.writeUTF(str);
              str = coupleArray[i].girl;
              opdos.writeUTF(str);
          }
          
          
          for(int i=0;i<noOfCouples;i++)
       {
           for(int j=0;j<noOfCouples-1;j++)
           {
               if(coupleArray[j].comp < coupleArray[j+1].comp)
               {
                     couple temp;
                     temp=coupleArray[j];
                     coupleArray[j]=coupleArray[j+1];
                     coupleArray[j+1]=temp;
               }
           }
       }
          
          for(int i=0;i<noOfCouples;i++)
    /*{
        System.out.println("happiness value "+coupleArray[i].tothap+" compatibility value"+coupleArray[i].comp);
    }*/
          
          
          opdos.writeUTF("The k most compatible couples are \n");
          for(int i=0;i<kcount;i++)
          {
              String str = coupleArray[i].boy;
              opdos.writeUTF(str);
              str = coupleArray[i].girl;
              opdos.writeUTF(str);
          }
          
          
    }
}
    
