import java.util.Scanner;
public class gametime{
public static void main(String[] args){
runmenu();
};
public static void runmenu () {
System.out.println("\nWelcome!");
System.out.println("1) for madlibs");
System.out.println("2) for number guesser");
System.out.println("3) for word guesser");
System.out.println("4) for exit");
System.out.println("Type a number and press enter");
Scanner in = new Scanner(System.in);
String response = in.nextLine();
if (response.equals("1")){
   madlibs.playGame();
}else if (response.equals("2")){
   numberguesser.generate();
}else if (response.equals("3")){
   System.out.print("Word Gueser");
}else if (response.equals("4")){
   in.close();
   return;
};
in.close();
runmenu();
}
}