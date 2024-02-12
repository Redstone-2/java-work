import java.util.Scanner;

/* Savannah Gray, 2/10, personlaizedmessage.java prompt*/

public class quiz{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter First Name");
String fname = in.nextLine();
System.out.println("Enter Last Name");
String lname = in.nextLine();
System.out.println("Enter Text");
String text = in.nextLine();
System.out.println(fname+" "+lname+" says "+text);
in.close();
}
}