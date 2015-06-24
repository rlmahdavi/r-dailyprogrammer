//get input exponent, power to raise digits to
//get input base, the starting base to be operated upon
//split base into digits
//each digit to the exponent power
//add each new digit together
//repeat until base = 1 or cycle is detected

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class SadCycle{
   private int exponent;
   private long base;
   
   public SadCycle(){
      this.exponent = 0;
      this.base = 0;
   }

   public static void main(String[] args){ 
      boolean cycleDetected = false;   
      ArrayList<Long> cycle = new ArrayList<Long>(); //holds all values computed so far
      int i = 1; //just for determining when to line break
   
      SadCycle MyCycle = new SadCycle();
      MyCycle.getInputs();
      
      while(MyCycle.getBase() != 1 && cycleDetected == false){
         MyCycle.addDigits(); 
         //if the new base has been computed before, a cycle has been found
         if (cycle.contains(MyCycle.getBase())) { cycleDetected = true; }
         else { cycle.add(MyCycle.getBase()); } //else add it to the list
         System.out.print(MyCycle.getBase() + " ");
         if (i % 10 == 0) { System.out.println(""); } //print a newline every 10 tries
         i++;
      }
      
   }
   
   private void getInputs(){
      
      Scanner input = new Scanner(System.in);
      //get valid exponent (any int > 0)
      while (this.exponent < 1) {
         System.out.println("Input exponent");
         this.exponent = input.nextInt();
      }
      //get valid base (any long > 0)
      while (this.base < 1) {
         System.out.println("Input base");
         this.base = input.nextInt();
      }  
      input.close();
   }
   
   //separates base into digits, pow(digit, exponent), and adds them back together
   private void addDigits(){
      int temp = 0;
      while (this.base > 0){
         //find the next digit, pow it, then add it back to temp
         temp += (int)Math.pow(this.base % 10, exponent);
         //remove that digit from base
         this.base /= 10;
      }
      this.base = temp;
   }
    
   
   public int getCyclePower(){
      return exponent;
   }
   public void setCyclePower(int exponent){
      this.exponent = exponent;
   }
   public long getBase(){
      return base;
   }
   public void setBase(long base){
      this.base = base;
   }
}