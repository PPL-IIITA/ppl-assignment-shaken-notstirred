/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8exception;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Pranjal
 */
public class Q8Exception {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
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
          for(int i=0;i<noOfCouples+2;i++)
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
          
          //Enter the Algorithm Selection Value here
          
          int selection_flag = 1;
          
          //Enter the Algorithm Selection Value above
          
          if(selection_flag == 0)
          {
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
           }
          
          else if(selection_flag == 1)
          {
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
             
             
             GiftClass[] type1 = new GiftClass[noOfGifts];
          
            for(int i=0;i<noOfGifts;i++)
               type1[i]=new GiftClass();
            
            GiftClass[] type2 = new GiftClass[noOfGifts];
          
            for(int i=0;i<noOfGifts;i++)
               type2[i]=new GiftClass();
            
            GiftClass[] type3 = new GiftClass[noOfGifts];
          
            for(int i=0;i<noOfGifts;i++)
               type3[i]=new GiftClass();
            int cnt1=0,cnt2=0,cnt3=0;
            
            for(int i=0;i<noOfGifts;i++)
            {
                if(giftArray[i].type == 1)
                    type1[cnt1++]=giftArray[i];
                
                else if(giftArray[i].type == 2)
                    type2[cnt2++]=giftArray[i];
                
                else if(giftArray[i].type == 3)
                    type3[cnt3++]=giftArray[i];
                
            }
             int ind1=0,ind2=0,ind3=0;
             for(int i=0;i<noOfCouples;i++)
             {
                 int cost=0;
                 int luxuryvalue=0;
                 int luxtot=0;
                 
                 while(cost < coupleArray[i].girlBud)
                 {
                    coupleArray[i].gifts[coupleArray[i].giftIndex]=type1[ind1]; 
                    cost+=type1[ind1].price;
                    luxtot+=type1[ind1].value;
                    if(type1[ind1].type == 2)
                        luxuryvalue+=type1[ind1].value;
                    ind1++;
                    coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
                    
                    if(cost >= coupleArray[i].girlBud)
                        break;
                    
                     coupleArray[i].gifts[coupleArray[i].giftIndex]=type2[ind2]; 
                    cost+=type2[ind2].price;
                    luxtot+=type2[ind2].value;
                    if(type2[ind2].type == 2)
                        luxuryvalue+=type2[ind2].value;
                    ind2++;
                    coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
                    
                    if(cost >= coupleArray[i].girlBud)
                        break;
                    
                     coupleArray[i].gifts[coupleArray[i].giftIndex]=type3[ind3]; 
                    cost+=type3[ind3].price;
                    luxtot+=type3[ind3].value;
                    if(type3[ind3].type == 2)
                        luxuryvalue+=type3[ind3].value;
                    ind3++;
                    coupleArray[i].giftIndex=coupleArray[i].giftIndex + 1;
      
                 }
                 
               //  System.out.println("Couple :"+i);
                 for(int k=0;k<coupleArray[i].giftIndex;k++)
                 {
              //       System.out.println("Type : "+coupleArray[i].gifts[k].type);
                 }
                 
                 coupleArray[i].totcost=cost;
                coupleArray[i].luxvalue=luxuryvalue;
                coupleArray[i].happinessGirl();
                coupleArray[i].happinessBoy();
                double tothappiness=coupleArray[i].happinessGirl() + coupleArray[i].happinessBoy();
                coupleArray[i].tothap=tothappiness;
                coupleArray[i].comp=coupleArray[i].compatibility();
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
          
     //     for(int i=0;i<noOfCouples;i++)
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
        catch(ArrayIndexOutOfBoundsException e)
        {
                System.out.println("Exception : An index out of the bounds of array is being accessed");
        }
        catch(ArithmeticException f)
        {
            System.out.println("Exception : An Arithematic Exception was encountered.check if you are dividing by 0");
        }
        catch(NullPointerException f)
        {
            System.out.println("Exception : NULL pointer encountered");
        }
        catch(FileNotFoundException f)
        {
            System.out.println("Exception : File not found");
        }
        catch(IOException d)
        {
           System.out.println("Exception : IO Exception"); 
        }
        catch(NumberFormatException e)
        {
            System.out.println("Exception : Number Format Exception"); 
        }
    }
    
}
