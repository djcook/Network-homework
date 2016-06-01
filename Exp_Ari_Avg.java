/*
   In this assignment, I had to complete the program to
   calculate the ecponential average and the arithmetic 
   average and have it write to a file in which we
   use to make a scatter plot graph to see the differences.
*/
import java.io.File;  
import java.io.PrintWriter;
import java.io.FileNotFoundException;  
import java.util.Scanner;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.util.ArrayList;  
import java.io.IOException;  
import java.util.Random;

public class Exp_Ari_Avg{  	 
	 public static double expAvg(double preExpAvg, int newSample){
	 	
		double a = .125;
		return (1 - a) * preExpAvg + a * newSample;
		// To be completed...
	 }
	 
	 public static double ariAvg(double preAriAvg, int newSample, int n){
		// To be completed...
		double x = (double)n;
		return (((x - 1) / x) * preAriAvg) + ((1 / x) * newSample);
	 }
	 
	 public static void sampleRTT2EstimatedRTT(Scanner in, PrintWriter out)throws IOException{ 
		
		Random r = new Random();
		int n = 1;
		double preExpAvg = (double)r.nextInt(101);
		double preAriAvg = (double)r.nextInt(101);

		while(in.hasNext() == true)
		{
			String st = in.next();
			if(st.startsWith("time=") || st.startsWith("time<"))
			{
				int time = 0;
				n++;
				for(int x = 5; x < st.length() - 2; x++)
				{
					time = Character.getNumericValue(st.charAt(x)) + time * 10;
				}
				
				preExpAvg = expAvg(preExpAvg, time);
				preAriAvg = ariAvg(preAriAvg, time, n);
 
				//System.out.printf("%d \t%.2f \t%.2f \n", time, preExpAvg, preAriAvg);
				out.printf("%d \t%.2f \t%.2f \n", time, preExpAvg, preAriAvg);
					
			}
		}
	 	// To be completed...
	 }
	 public static void main (String[] args){ 
	 	try{
			
			Scanner fileScanner = new Scanner(new File("data.txt")); 
			PrintWriter filePrinter = new PrintWriter(new File("output.txt"));
			
			filePrinter.print("SampleRTTs\tExpAvgs\tAriAvgs");
			filePrinter.println();
			
			sampleRTT2EstimatedRTT(fileScanner, filePrinter);
			
			fileScanner.close();
			filePrinter.close();
	
		}catch(IOException e){
			System.out.println("Error opening file.");
			System.exit(0);
		}
		
		
	 }
}  
