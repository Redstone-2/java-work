//Savannah Gray 2/2/2022

import java.util.Scanner;

public class test{
   public static void main (String[] args){
    System.out.println("What's your name?");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    System.out.println("Hello \""+name+"\"");
    in.close();
   }
}