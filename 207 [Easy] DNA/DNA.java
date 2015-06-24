//take a series of DNA bases like A A T G C A T T G
//create the other side of the helix
//A pairs with T, C pairs with G

import java.util.ArrayList;
import java.util.Random;

public class DNA{
   public static void main(String[] args){
      ArrayList<Character> RNA = new ArrayList<Character>();
      ArrayList<Character> complement = new ArrayList<Character>();
      
      RNA = generateRNA();
      showList(RNA);
      complement = duplicate(RNA);
      showList(complement);
   }

   //generates the starting RNA sequence
   private static ArrayList<Character> generateRNA(){
      Random rand = new Random();
      ArrayList<Character> RNA = new ArrayList<Character>();
      char[] pool = {'A','T','G','C'};  //pool of possible bases
      int size = 15 + rand.nextInt(11); //random size between 15 and 25
      
      for (int i = 0; i < size; i++){
         RNA.add(pool[rand.nextInt(4)]); //get a random letter from pool and append it to RNA
      }
      
      return RNA;
   }

   //from a given RNA sequence, finds the complement of every base
   private static ArrayList<Character> duplicate(ArrayList<Character> original){
      ArrayList<Character> complement = new ArrayList<Character>();
      for (char base: original){
         complement.add(findComplement(base)); 
      }
      return complement;
   }

   //finds the complement of an individual base
   private static char findComplement(char input){
      char complement = ' ';
      switch (input) {
         case 'A': complement = 'T'; break;
         case 'T': complement = 'A'; break;
         case 'G': complement = 'C'; break;
         case 'C': complement = 'G'; break;
      }
      return complement;
   }
   
   private static void showList(ArrayList<Character> list){
      for (char base: list){
         System.out.print(base + " ");
      }
      System.out.println("");
   }
}
