/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4exception;

/**
 *
 * @author Pranjal
 */
public class couple {
  String boy;
    String girl;
    int boyid;
    int girlid;
    int boyType;
    int girlType;
    int boyBud;
    int girlBud;
    int boyAtt;
    int girlAtt;
    int boyint;
    int girlint;
    int girlhap;
    int boyhap;
    double tothap;
    int totcost;
    int luxvalue;
    int totvalue;
    double comp;
    
    GiftClass gifts[]=new GiftClass[50];
    int giftIndex=0;
 //   int hap=0;
    
    public int happinessGirl()
    {
        if(girlType==0)
        {
            girlhap=(int)Math.log10(totcost-girlBud+(2*luxvalue));
    //        System.out.println("girl happiness value is "+girlhap+"of "+girlid);
        }
        else if(girlType==2)
        {
            girlhap=(int)(Math.pow(2.73,(totcost-girlBud)))%20;
      //      System.out.println("girl happiness value is "+girlhap+"of "+girlid);
        }
        else if(girlType==1)
        {
            girlhap=totcost+totvalue;
        //    System.out.println("girl happiness value is "+girlhap+"of "+girlid);
        }
        
        return girlhap;
    }
    public int happinessBoy()
    {
        if(boyType==0)
        {
           boyhap=boyBud-girlBud;
        }
        else if(boyType==1)
            boyhap=girlhap;
        else if(boyType==2)
            boyhap=girlint;
       // System.out.println("happiness value is "+boyhap+"of "+boyid);
        return boyhap;
    }
    public double compatibility()
    {
        comp = (Math.abs(girlBud-boyBud) + Math.abs(boyint-girlint) + Math.abs(boyAtt-girlAtt));
        return comp;
    }  
}
