/*Rameen Mahdavi
 *
 *r/dailyprogrammer challenge #218 [easy]
 *Takes integer input, reverses it and adds it to the original
 *then repeats this process until the resulting integer is palindromic
 *(the same forwards and backwards)
 */

import java.util.Scanner;


public class Palindrome{

   public static void main(String[] args){
      //Set up Scanner & get proper input
      Scanner input = new Scanner(System.in);
      long original = 0;
      while (original < 1){
         System.out.println("Input a positive integer.");
         original = input.nextInt();
      }
      ResultClass answer = getPalindromic(original);
      //Prints out the final number, getPalindromic() handles intermediate steps
      System.out.println("\nThe palindrome is: " + answer.getResult() + " and it took " + answer.getTries() + " step(s).");
   }

   //Find the palindromic of the input, prints each step along the way
   public static ResultClass getPalindromic(long original){
      boolean palindromic = false;
      long current = original;
      long reversed = 0;
      int maxTries = 10000; //Some numbers are not palindromic and will go forever otherwise
      int tries = 0;
      
      //While the number isn't palindromic, find its reverse and it to itself until it is
      while (palindromic == false && tries < maxTries){
         reversed = reverseInt(current);
         current = current + reversed;
         //Show progress
         System.out.print(current + " ");
         //Check if done
         if (current == reverseInt(current)) { palindromic = true; }
         tries++;
      }
      
      return new ResultClass(tries, current);
   }

   //input = 12345 output = 54321
   public static long reverseInt(long original){
      long reversed = 0;
      
      while (original != 0){
         reversed = reversed * 10 + original % 10;
         original = original / 10;
      }
      
      return reversed;
   }

}

//holds the results for us
final class ResultClass{
   private final int tries; //number of steps
   private final long result; //the final palindrome
   
   public ResultClass(int tries, long result){
      this.tries = tries;
      this.result = result;
   }
   
   public long getTries(){
      return tries;
   }
   
   public long getResult(){
      return result;
   }

}