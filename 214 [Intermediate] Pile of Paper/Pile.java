/* Rameen Mahdavi
 * 
 * r/dailyprogrammer challenge 214 Intermediate
 * Create a pile (2d array of ints)
 * Allows the user to place pieces of paper on the pile (rectangles of different colors)
 * Count how much of each color is visible at the end (more recent pieces of paper go on top of older ones)
 */


import java.util.Scanner;
import java.util.TreeMap; //for the counts
import java.util.Map;     //for Map.Entry to iterate over map

public class Pile{
   //Array of arrays of ints (pile) that would represent the board
   private int[][] pile;
   //this TreeMap is used to keep track of an array of tuples like (color, # of blocks of that color)
   //TreeMap is used because it's sorted automatically -- colors are represented by ints so they'll be sorted when output
   TreeMap<Integer, Integer> colorCounts = new TreeMap<Integer, Integer>();
   
   //constructor
   public Pile(int width, int height){
      pile = new int[height][width];
   }
   
   //main
   public static void main(String[] args){
      //get starting inputs as "x y" x = width y = height
      System.out.println("Enter dimensions of pile in the format \"width height\" e.g. 20 10");
      Scanner keyboard = new Scanner(System.in);
      String pileSize = keyboard.nextLine();              //get both inputs on one line
      String[] pileSizeSplit = pileSize.split(" ");       //split them up
      int pileWidth = Integer.parseInt(pileSizeSplit[0]); //divvy them out
      int pileHeight = Integer.parseInt(pileSizeSplit[1]);
      
      //declare your pile - it will start blank (all 0's)
      Pile myPile = new Pile(pileWidth, pileHeight);
      
      String paper;
      boolean gettingInput = true;
      while (gettingInput == true){
         //show current pile
         myPile.printPile();
         //take input in the form of "a b c d e"
         //a = color, b = row, c = col, d = width, e = height
         System.out.println("\nEnter dimensions of the scrap of paper in the format a b c d e");
         System.out.println("a = color, b = row, c = col, d = width, e = height");
         System.out.println("Or enter q to quit");
         paper = keyboard.nextLine();
         //mark a rectangle with those specs onto the pile
         if (paper.equals("q")) { gettingInput = false; continue; }
         myPile.mark(paper);
      }
      
      myPile.calcAreas();
      
      //print out the counts of each color -- ordered already because of TreeMap
      for (Map.Entry<Integer, Integer> color : myPile.colorCounts.entrySet()){
         Integer key = color.getKey();
         Integer value = color.getValue();
         System.out.println(key + " " +value);
      }
      
      keyboard.close();
    }  
      
   //places a piece of paper with the given dimensions on the pile
   private void mark(String paper){
      //split the input string into the color and dimensions
      String[] paperDims = paper.split(" ");
      int color = Integer.parseInt(paperDims[0]);
      int row = Integer.parseInt(paperDims[1]);
      int col = Integer.parseInt(paperDims[2]);
      int width = Integer.parseInt(paperDims[3]);
      int height = Integer.parseInt(paperDims[4]);
   
      for (int i = row; i < row + height; i++){
         for(int j = col; j < col + width; j++){
            pile[i][j] = color;
         } 
      }
   
   }

   //print contents of the pile
   private void printPile(){
      for(int[] line: pile){
         for(int block: line){
            System.out.print(block);
         }
         System.out.println("");
      }
   }

   //finds the amount of blocks of each color and stores them in the map
   private void calcAreas(){
      //for each row
      for (int i = 0; i < pile.length; i++){
         //for each col in that row
         for (int j = 0; j < pile[i].length; j++){
            //pile[i][j] is the color in that square
            //the map contains (color, # of that color)
            if (colorCounts.get(pile[i][j]) == null) {
               //it initializes to null instead of zero, so set to 1 if null
               colorCounts.put(pile[i][j], 1);
            }
            else{
               //otherwise just add 1 to the count
               colorCounts.put(pile[i][j], colorCounts.get(pile[i][j]) + 1);
            }
         }
      }
   }
}