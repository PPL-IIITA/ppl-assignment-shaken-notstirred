/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.q9;

/**
 *
 * @author Pranjal
 */
public class template {
    
    static void method(girl array[],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
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
    }
    
    static void method(GiftClass array[],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
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
    }
    
    
}
