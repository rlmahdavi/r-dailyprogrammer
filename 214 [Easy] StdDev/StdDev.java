//calculate std dev from a list of numbers
//1. calculate mean of values
//2. for each value, calculate the difference between it and the mean value, then square that difference
//3. calculate the sum of all the values from prev step
//4. divide that sum by the number of values, this gives variance
//5. take square root of the variance to get std dev

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class StdDev{

   public static void main(String[] args){
      ArrayList<Integer> dataSet = new ArrayList<Integer>(); //input
      float mean = 0; //for step 1
      ArrayList<Float> squaredDiffs = new ArrayList<Float>(); //for step 2
      float sum = 0; //for step 3
      float variance = 0; //for step 4
      float stdDev = 0; //for step 5
      
      dataSet = generateInput(dataSet); //Step 0... fake inputs because I'm lazy
      
      
      
      mean = calcMean(dataSet); //Step 1
      squaredDiffs = calcSquaredDiffs(dataSet, mean); //Step 2
      for (int i = 0; i < squaredDiffs.size(); i++){ //Step 3
         sum += squaredDiffs.get(i);
      }
      variance = sum / squaredDiffs.size(); //Step 4
      stdDev = (float)Math.sqrt(variance);
      System.out.println("Your standard deviation is: " + stdDev);
      
   }
   
   //generate a random list of inputs
   //the list will have between 10 and 20 ints with range 0 to 99
   private static ArrayList<Integer> generateInput(ArrayList<Integer> dataSet){
      Random rand = new Random();
      int listSize = rand.nextInt(10) + 10; //random value between 10 and 20 for list size
      for (int i = 0; i < listSize; i++){
         dataSet.add(rand.nextInt(100)); 
      }
      return dataSet;
   }

   //returns the mean of the given list of integers
   private static float calcMean(ArrayList<Integer> dataSet){
      int sum = 0;
      float mean;
      
      for (int i = 0; i < dataSet.size(); i++){
         sum += dataSet.get(i); // add each item to sum
      }
      mean = (float)(sum / dataSet.size()); //mean is sum / number of elements
      return mean;
   }
   
   //for each value in dataSet, find the difference between it and mean, then square the difference
   private static ArrayList<Float> calcSquaredDiffs(ArrayList<Integer> dataSet, float mean){
      float difference;
      ArrayList<Float> temp = new ArrayList<Float>();
      
      for (int i = 0; i < dataSet.size(); i++){
         difference = (float)dataSet.get(i) - mean; //difference = value - mean
         temp.add((float)Math.pow(difference, 2)); //square difference and add to list
      }
      return temp;
   }
   
}