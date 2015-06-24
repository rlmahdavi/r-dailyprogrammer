/*
Rameen Mahdavi
r/dailyprogrammer #219 Easy & Intermediate - To-do List

functionality:
   add item to the to-do list
   delete a selected item from list
   print out list

*/

//import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Todo{
   private Map<String, String[]> tasks = new HashMap<String, String[]>();
   
   public static void main(String[] args){
      Todo myTodo = new Todo();
      Scanner keyboard = new Scanner(System.in);
      int selection = 0;
      String inputTask;
      String categories;
      
      //read data from file, if it exists
      try{
         File readFile = new File("Tasks.txt");
         FileInputStream storage = new FileInputStream(readFile);
         ObjectInputStream read = new ObjectInputStream(storage);
         myTodo.tasks = (HashMap<String, String[]>)read.readObject();
         read.close();
      }catch(Exception e){
         System.out.println(e);
      }
      
      while (selection != 6){
         System.out.println("What would you like to do?");
         System.out.println("1 - Add an item");
         System.out.println("2 - Delete an item");
         System.out.println("3 - Modify an item");
         System.out.println("4 - View entire list");
         System.out.println("5 - View a category");
         System.out.println("6 - Done");
         selection = keyboard.nextInt();
         keyboard.nextLine(); //because nextInt() doesn't consume newline char
         
         switch(selection){
            //add an item
            case 1: System.out.println("What task would you like to add?");
                    inputTask = keyboard.nextLine();
                    System.out.println("What categories does the task have?");
                    categories = keyboard.nextLine();
                    myTodo.addItem(inputTask, categories);
                    break;
            //delete an item
            case 2: System.out.println("What task would you like to delete?");
                    myTodo.deleteItem(keyboard.nextLine());
                    break;
            //modify an item
            case 3: System.out.println("What task should be modified?");
                    inputTask = keyboard.nextLine();
                    myTodo.deleteItem(inputTask);
                    System.out.println("What should it be replaced with?");
                    inputTask = keyboard.nextLine();
                    System.out.println("What categories does the new task have?");
                    categories = keyboard.nextLine();
                    myTodo.addItem(inputTask, categories);
                    break;
            //view entire list
            case 4: myTodo.viewList(); break;
            //view entries that fit the category
            case 5: System.out.println("View which category?");
                    categories = keyboard.nextLine();
                    myTodo.viewCategory(categories);
                    break;
            //save and quit
            case 6: try{
                       File file = new File("Tasks.txt");
                       FileOutputStream saveFile = new FileOutputStream(file);
                       ObjectOutputStream save = new ObjectOutputStream(saveFile);
                       save.writeObject(myTodo.tasks);
                       save.close();
                    } catch(Exception e){
                       System.out.println(e);
                    }
                    break;
            default: break;
         }
      }
      keyboard.close();
   }

   private void addItem(String newTask, String categories){
      tasks.put(newTask, categories.split(" "));
   
   }
   
   private void deleteItem(String finishedTask){
      if (tasks.containsKey(finishedTask)){
         tasks.remove(finishedTask);
      }
   }
   
   
   private void viewList(){
      for (Map.Entry<String, String[]> element: tasks.entrySet()){
         System.out.print("Task: " + element.getKey() + "   Categories: ");// + element.getValue());
         for (String cat: element.getValue()){
            System.out.print(cat + " ");
         }
         System.out.println("");
      }
   }
   
   private void viewCategory(String categories){
      //for each element in the map
      for (Map.Entry<String, String[]> element: tasks.entrySet()){
         //if the given category is in the task's list of categories
         for (String category: element.getValue()){
            if (category.equals(categories)){
               System.out.print("Task: " + element.getKey() + "   Categories: ");
               for (String cat: element.getValue()){
                  System.out.print(cat + " ");
               }  
               System.out.println("");
            }
         }
      }
   }


}