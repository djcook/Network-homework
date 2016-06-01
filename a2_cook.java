/*
   In this assignment, I had to make a short program to 
   make a graph in excel to produce a plot the size of each packet
   vs the end to end delay of the transmission of an entire message.
*/
import java.util.*;
import java.io.*;

public class a2_cook
{
   public static void main(String[] args)
   {
      float data = 16000;
      float packet;
      float n;
      float overhead = 20; // we have to try 0, 10, and 20
      float d_trans;
      float d_prop = 1;
      float endTime;
      
      packet = data/4; //size of packet
      n = data/packet; //amount of packets
      
      while(packet >= 125)
      {
         float temp = packet + overhead;//adding overhead
         d_trans = temp/4000;
         endTime = (n + 2) * d_trans + d_prop * 3;   
         
         System.out.printf("Packet Size: %.0f\n", packet);
         System.out.printf("End to End Time: %f\n\n", endTime);
         
         packet = packet/2;//half packet size
         n = data/packet;//get new amount of packets 
      }
      
   }
   
}