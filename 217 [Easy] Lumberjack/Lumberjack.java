/*Rameen Mahdavi
 *
 *r/dailyprogrammer #217 [Easy]
 *
 *
 */

public class Lumberjack{
   private int size = 3;
   private int logs = 7;
   private int[] pile = new int[]{1, 1, 1, 
                                  2, 1, 3,
                                  1, 4, 1}; //hardcoded for now
   
   public static void main(String[] args){

      Lumberjack lumber = new Lumberjack();
      lumber.showPiles(); //show before
      
      int smallest = lumber.findSmallestPile();
      lumber.distributeLogs(smallest);
      
      lumber.showPiles(); //show after
   }
   
   //finds the smallest pile of lumber in the yard
   private int findSmallestPile(){
      int smallest = pile[0];
      //compare each pile to the current smallest pile to find smallest
      for (int i = 0; i < this.pile.length; i++){
         if (this.pile[i] < smallest) {smallest = pile[i];}
      }
      return smallest;
   }
   
   private void distributeLogs(int smallest){
      //keep going until we run out of logs
      while(logs > 0){  
         //go through each pile 
         for (int i = 0; i < this.pile.length; i++){
            //only put logs in the smallest piles
            if (this.pile[i] == smallest) {
               if (this.logs < 1) {break;}
               this.pile[i]++;
               this.logs--;
            }
         }
         //smallest is always 1 bigger 
         smallest++;
      }
   }
   
   private void showPiles(){
      for(int i = 0; i < this.pile.length; i++){
         if (i % this.size == 0) {System.out.println("");}
         System.out.print(this.pile[i] + " "); //space after every pile
      }
      System.out.println(""); //line after every row
   }

}
