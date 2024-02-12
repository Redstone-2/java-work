import java.util.Scanner;

/* Savannah Gray, 2/9/22 */

public class anglecalculator{
public static void main (String[] args){
   Scanner in = new Scanner(System.in);
   System.out.println("Enter amount of angles");
   int reply = in.nextInt();
   in.close();
   double amount = 360.0/reply;
   System.out.println("A "+reply+"-sided polygon has an angle of "+amount);
   }
}