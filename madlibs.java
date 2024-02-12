import java.util.Scanner;

public class madlibs{
   public static void main (String[] args){
   playGame();
   };
   
   public static void playGame(){
   String a ="";
      System.out.print("One day, while I down at the "+getinfo("place")+". This "+
         getinfo("adjective")+" person came up to me and said,\n\"You are very "+
         getinfo("adjective")+". Would you like to grab (a) "+
         getinfo("food")+"?\" \nI agreed and we headed towards "+
         getinfo("restraunt")+". We sat down at a nearby\n"+getinfo("noun")+" and they ate the "+
         (a = getinfo("noun"))+" they ordered.\nYou stare "+getinfo("adjective ending in ingly")+
         " at them. \"Ive never seen\nanyone "+getinfo("verb")+" a that much "+a+" before!\" you exclaim. You exchange "
         +getinfo("Noun(Plural)")+" with them\nbefore heading home. It was the "+getinfo("adjective")+" date ever!");
   };
   public static String getinfo (String pos){
   Scanner in = new Scanner(System.in);
   System.out.println("Enter a "+pos);
   String reply = in.nextLine();
   in.close();
   return reply;
   }
}