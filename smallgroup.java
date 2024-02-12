import java.util.Scanner;

/* Savannah Gray, 2/9/22 */

public class smallgroup{
public static void main (String[] args){
   Scanner in = new Scanner(System.in);
   System.out.println("Enter amount of students");
   int reply = in.nextInt();
   System.out.println("There are "+(reply/4)+" groups of 4 students and "+(reply % 4)+" students left over");
   in.close();
   }
}