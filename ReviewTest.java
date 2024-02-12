import java.util.Scanner;
public class ReviewTest{
   public static void main (String[] args){
      testMethod();
      testWithUserInput();
   };
   public static String determinWetSuitType(int wt){
      String type = "";
      String thick = "";
      if (wt > 75){
      type = "Rashguard";
      thick = "N/A";
      }else if(wt >= 65){ 
      type = "Springsuit / Top";
      thick = "1-2mm";
      }else if(wt >= 62 ){
      type = "Fullsuit";
      thick = "2-3mm";
      }else{
      return "To Cold!";
      };
      return "Wetsuit type: "+type+" Thickness of "+thick;
   };
   public static void testMethod(){
      System.out.println(determinWetSuitType(100));
      System.out.println(determinWetSuitType(63));
      System.out.println(determinWetSuitType(67));
      System.out.println(determinWetSuitType(2));
   };
   public static void testWithUserInput(){
   try (Scanner in = new Scanner(System.in)) {
      System.out.println("Enter water temp");
      System.out.println(determinWetSuitType(in.nextInt()));
   }
   }
}