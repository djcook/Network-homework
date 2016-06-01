//Dylan Cook a1 Networking
/*
   In this homework assignment, I am solving for the minimum value of
   a shared link B between 20 users to have a less than .5% probability
   of packet queuing.
*/
import java.util.*;
import java.io.*;

public class a1
{
   public static void main(String[] args)
   {
      double b = .2;
      double link = b; // B
      double m = 20;
      double p = .02;
      double noQ;
      double probQ;
      
      while(true)
      {
         probQ = 0;
         noQ = 0;
         double n = link/b;
         for(int x = 0; x <= n; x++)
         {
            noQ += ((fac(m))/((fac(x))*(fac(m-x))))*(Math.pow(p,x))*(Math.pow(1-p,m-x));
            //System.out.printf("noQ = %.15f Mbps\n",noQ);
         }
         
         probQ = 1 - noQ;
         System.out.printf("B Iteration%.0f = %.1f Mbps\n",n,link);
         //System.out.printf("probQ = %.15f Mbps\n\n",probQ);
         if(probQ < .005)
         {
            break;
         }
         link += b;       
      }
      System.out.printf("B: %.1f Mbps\n",link);
   }
   
   public static double fac(double n)
   {
      double fact = 1;
      if(n != 0)
      {
         for(int i = 1; i <= n; i++)
         {
            fact *= i;
         }
      }
      return fact;
   }
}