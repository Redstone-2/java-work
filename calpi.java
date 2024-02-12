import java.util.Scanner;
public class calpi{
public static void main(String[] Args){
Scanner myObj = new Scanner(System.in);
System.out.println("enter circumfrence");
      int c = myObj.nextInt();
System.out.println("enter radius");
      int r = myObj.nextInt();
      System.out.print(c/2*r);
      myObj.close();
   }
}
