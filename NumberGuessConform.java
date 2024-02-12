import java.util.Scanner;
public class NumberGuessConform{
private static Scanner in = new Scanner(System.in);
public static void main (String[] args){
playGame();
};
public static void playGame(){
   int low = 1;
   int high = 20;
   evaluateGuess(low, high, getNumInRange(low, high));
};
public static int getGuess(int min, int max){
   System.out.println("Guess a number between "+min+" and "+max);
   return in.nextInt();
};
public static int getNumInRange(int min, int max){
   return (int)(Math.random() * (max-min+1)) + min;
};
public static void evaluateGuess(int low, int high, int numToGuess){
int userguess = getGuess(low, high);
 if (low<=userguess && userguess<=high){
   if (userguess == numToGuess){
   System.out.println("You Win!");
   return;
   }else if (userguess > numToGuess){
   System.out.println("To High");
   high = userguess;
   }else if (userguess < numToGuess){
   System.out.println("To Low");
   low = userguess;
   };
 }else {
   System.out.println("That isn't between "+low+" and "+high);
   evaluateGuess(low, high, numToGuess);
}
}
}