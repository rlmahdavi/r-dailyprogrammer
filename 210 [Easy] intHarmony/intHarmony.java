//get 2 integers as input
//find how many bits are shared between two unsigned 32 bit values
//represent this as a percentage
//we use longs because java always uses signed numbers

import java.util.Scanner;
import java.lang.Math;

public class intHarmony{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Long first, second;
      float compatibility;
      String unparsed;
      
      System.out.println("First number");
      first = (long)input.nextInt();
      System.out.println("Second number");
      second = (long)input.nextInt();
      
      System.out.println("first is  " + Long.toBinaryString(first));
      System.out.println("second is " + Long.toBinaryString(second));
      compatibility = calcCompatibility(first, second);
      
      System.out.println(compatibility * 100);
      
      input.close();
   }
   
   //find shared bits by anding first and second, then invert them and do it again
   //The compatibility = shared bits / total bits
   //Java int type is 32 bits
   private static float calcCompatibility(Long first, Long second){
      int sharedBits = 0;
      //XOR tells us which bits are different, so its inverse tells us which bits are the same
      Long masked; 
      float compatibility;
      
      masked = ~(first ^ second); //inverse XOR
      
      System.out.println("Masked is " + Long.toBinaryString(masked));
      
      //see if the least significant bit is 1, increment sharedBits if it is, 
      //then shift to the right until no 1's left
      for (int i = 0; i < 32; i++){
         if ((masked & 1L) == 1) { sharedBits++; }
         masked = masked >>> 1;
      }
      
      System.out.println("sharedBits is " + sharedBits);
      
      //find percentage, we use longs because ints are
      compatibility = ((float)sharedBits / 32);
      return compatibility;
   }


}