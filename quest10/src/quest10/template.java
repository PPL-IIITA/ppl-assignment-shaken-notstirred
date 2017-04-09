/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.quest10;

/**
 *
 * @author Pranjal
 */
public class template {
static void method(girl array[],int n)
    {
        int b=n/2;
         for(int i=0;i<b;i++)
        {
            for(int j=0;j<b-1;j++)
            {
               if(array[j].maintenanceBudget > array[j+1].maintenanceBudget)
               {
                   girl temp;
                   temp = array[j];
                   array[j]=array[j+1];
                   array[j+1]=temp;
               }
            }
        
         }
         
         for(int i=b+1;i<n;i++)
        {
            for(int j=b+1;j<n-1;j++)
            {
               if(array[j].maintenanceBudget < array[j+1].maintenanceBudget)
               {
                   girl temp;
                   temp = array[j];
                   array[j]=array[j+1];
                   array[j+1]=temp;
               }
            }
        
        }
         
         
    }

static void method(GiftClass array[],int n)
    {
        int b=n/2;
         for(int i=0;i<b;i++)
        {
            for(int j=0;j<b-1;j++)
            {
               if(array[j].value > array[j+1].value)
               {
                   GiftClass temp;
                   temp = array[j];
                   array[j]=array[j+1];
                   array[j+1]=temp;
               }
            }
        
         }
         
         for(int i=b+1;i<n;i++)
        {
            for(int j=b+1;j<n-1;j++)
            {
               if(array[j].value < array[j+1].value)
               {
                   GiftClass temp;
                   temp = array[j];
                   array[j]=array[j+1];
                   array[j+1]=temp;
               }
            }
        
        }
         
         
    }
           
}
