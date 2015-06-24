/*
Rameen Mahdavi

r/dailyprogrammer challenge #220 Easy
Mangle an input sentence by sorting the letters in each word e.g. "hello world" -> "ehllo dlorw"
Capitalized letters should have the letter in that place capitalized e.g. "Dailyprogrammer" -> "Aadegilmmoprrry"
Punctuation should stay in the same place e.g. "doesn't" -> "denos't"
*/

import java.util.Scanner;
import java.util.Arrays;

public class Mangler{
   public static void main(String[] args){
      String input = getInput();
      String[] mangled = mangle(input);
      
      for (String word: mangled){
         System.out.print(word + " ");
      }
   }
   
   private static String getInput(){
      Scanner keyboard = new Scanner(System.in);
      String input = keyboard.nextLine();
      return input;
   }

   private static String[] mangle(String input){
      //Split the input string into words
      String[] mangled = input.split(" ");
      
      //sort each word in the array of strings by converting to array, sorting array, then converting back
      for (int i = 0; i < mangled.length; i++){
         //char[] wordArray = mangled[i].toCharArray();
         //Arrays.sort(wordArray);
         mangled[i] = sort(mangled[i]);
      }
      return mangled;
   }

   private static String sort(String unsorted){
      char[] unsortedArray = unsorted.toCharArray();
      for (int i = 1; i < unsortedArray.length; i++){
         char temp = unsortedArray[i];
         int j;
         for (j = i - 1; j >= 0 && temp < unsortedArray[j]; j--)
            unsortedArray[j + 1] = unsortedArray[j];
         unsortedArray[j + 1] = temp;
      }
      String sorted = new String(unsortedArray); 
      return sorted;
   }


}