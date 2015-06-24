//input: a list of integers of arbitrary size
//cull the repeats and print the string back out

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Culler{

   public static void main(String[] args){
      ArrayList<Integer> inputs = new ArrayList<Integer>();
      ArrayList<Integer> culled = new ArrayList<Integer>();
      inputs = generateInput();
      Collections.sort(inputs); //for prettiness
      showList(inputs); //show the before
      culled = cullDuplicates(inputs);
      showList(culled); //results
   }

   private static ArrayList<Integer> generateInput(){
      Random rand = new Random();
      int size;
      ArrayList<Integer> inputs = new ArrayList<Integer>();
      
      //generate 15 to 25 numbers from 0 to 20
      size = 15 + rand.nextInt(11);
      for (int i = 0; i < size; i++){
         inputs.add(rand.nextInt(21));
      }
      
      return inputs;
   }
   
   //this keeps only the first instance of any given integer, but could be easily modified to keep last
   //doesn't matter if the list is sorted
   private static ArrayList<Integer> cullDuplicates(ArrayList<Integer> inputs){ 
      int i = 0;
      //for (int i = 0; i < inputs.size(); i++){
      while(i < inputs.size()){
         //find the index of the first occurance of the element at index i
         //if this index isn't i then the element at i is a duplicate so erase it
         if (inputs.indexOf(inputs.get(i)) != i){
            inputs.remove(i); 
         }
         else{
         //if we remove an element we don't want to increment i,
         //as we'd skip the element that gets moved into i's place
            i++; 
         }
      }
      return inputs;
   }
   
   //prints out the contents of an ArrayList<integer> all on one line
   private static void showList(ArrayList<Integer> list){
      for (int i = 0; i < list.size(); i++){
         System.out.print(list.get(i) + " ");
      }
      System.out.println("");
   }

}