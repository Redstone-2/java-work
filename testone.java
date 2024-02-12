import java.util.Scanner;
public class testone{
   public static void main(String[] Args){
      testMethod();
      System.out.println(recursiveFactorial(17));
      testWithUserInput();
   };
   public static String getRiverStatus(int wl){
      if (wl >= 12){
      return "River Stage: Flood Stage, Requirements: Permit Required";
      }else if (wl >= 9){
      return "River Stage: Action Stage, Requirements: Permit Required";
      }else if (wl >= 5){
      return "River Stage: High, Requirements: Life Jacket";
      }else {
      return "River Stage: Normal, Requirements: None";
      }
   };
   public static void testMethod(){
      System.out.println(getRiverStatus(20));
      System.out.println(getRiverStatus(10));
      System.out.println(getRiverStatus(7));
      System.out.println(getRiverStatus(3));
   };
   public static void testWithUserInput(){
      try (Scanner in = new Scanner(System.in)) {
         System.out.println("Enter Water Level");
         System.out.println(getRiverStatus(in.nextInt()));
      }
   };
   public static int recursiveFactorial(int x){
      if (x != 1){
      return x * recursiveFactorial(x-1);
      } else{
      return 1;
      }
   }
}