import java.util.Scanner;
public class numberguesser{
private static int min;
private static int max;
private static int random;
private static Scanner in;
public static void main(String[] args){
   generate();
};
public static void generate(){
   random = (int)(Math.random() * (100-1)) + 1;
   in = new Scanner(System.in);
   max = 100;
   guessnumber();
};
public static void guessnumber(){
   System.out.println("Guess a number "+min+"-"+max);
   int response = in.nextInt();
   if (min<=response && response<=max){
      if (response > random){
         System.out.println("Lower");
         max = response;
      }else if (response == random){
         System.out.print("Correct!");
         return;
      }else if (response < random){
         System.out.println("Higher");
         min = response;
      };
   }else{
   System.out.println("That isnt a number between "+min+" and "+max);
   };
   guessnumber();
};
}