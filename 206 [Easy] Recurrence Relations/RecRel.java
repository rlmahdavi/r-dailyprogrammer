/* f(0) = 1
   f(n + 1) = 2 * u(n)
   1. process input... *3 +2 *2 means the recurrence relation does those in that order
         split into substrings, spaces are separators
         first char in substring is the operation, then the rest is the number
      then get the starting value as an integer
      then get the n we want
   2. write a function that implements the recurrence relation
   3. write a recursive function that uses the recurrence relation function to find the nth element in the series
 */

import java.util.Scanner;

public class RecRel{
   private String[] operations; //the operations to be completed, split into substrings
   private int start; //value of f(0)
   private int goal;  //which term is desired.. f(goal)


   public static void main(String[] args){
      RecRel myRecRel = new RecRel();
      
      myRecRel.getInputs();
      System.out.println("Term 0: " + myRecRel.start);
      System.out.println("Term " + myRecRel.goal + ": " + myRecRel.findTerm(myRecRel.operations, myRecRel.start, myRecRel.goal, 1));
   }

   private void getInputs(){
      String rawInput;
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter the recurrence relation ex. *3 +2 *2");
      rawInput = input.nextLine();
      operations = rawInput.split(" ");
      
      System.out.println("Enter the first term, f(0)");
      start = input.nextInt();
      
      System.out.println("Enter which term should be calculated");
      goal = input.nextInt();
      
      input.close();
   }

   /*private int recRel(int input){
      String numberStr;
      for (String op: operations){
         //the 0th character of each substring is the operation to be performed
         //everything after is the integer it should be performed on
         numberStr = op.substring(1);
         switch (op.charAt(0)){
            case '+': input += Integer.parseInt(numberStr);break;
            case '-': input -= Integer.parseInt(numberStr);break;
            case '*': input *= Integer.parseInt(numberStr);break;
            case '/': input /= Integer.parseInt(numberStr);break;
            default: break;
         }
      }
      
      return input;
   }*/
   
   //private void findTerm(int term){
      ////non-recursive way, using for loop
      //for (int i = 0; i < term; i++){
      //   start = recRel(start);
      //   System.out.println("Term " + i + ": " + start);
      //}
      
   //}
   
   private int findTerm(String[] operations, int input, int goal, int nextTerm){
      goal--;

      String numberStr;
      for (String op: operations){
         //the 0th character of each substring is the operation to be performed
         //everything after is the integer it should be performed on
         numberStr = op.substring(1);
         switch (op.charAt(0)){
            case '+': input += Integer.parseInt(numberStr);break;
            case '-': input -= Integer.parseInt(numberStr);break;
            case '*': input *= Integer.parseInt(numberStr);break;
            case '/': input /= Integer.parseInt(numberStr);break;
            default: break;
         }
      }

      
      if (goal == 0){
         return input;
      }
      else{
         System.out.println("Term " + nextTerm + ": " + input);
         return findTerm(operations, input, goal, nextTerm + 1); 
      }
   
   }

}