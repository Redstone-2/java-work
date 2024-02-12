import java.util.*;  // import all classes in this package.
public class Shopping
{
   public static void main(String[] args)
   {
      ArrayList<String> shoppingList = new ArrayList<String>();
      System.out.println("Size: " + shoppingList.size());
      shoppingList.add("carrots");
      System.out.println(shoppingList);
      shoppingList.add("bread");
      System.out.println(shoppingList);
      shoppingList.add("chocolate");
      System.out.println(shoppingList);
      System.out.println("Size: " + shoppingList.size());
      ArrayList<Integer> quantities = new ArrayList<Integer>();
      quantities.add(2);
      quantities.add(4);
      quantities.add(1);
      System.out.println(quantities);
   }
}
