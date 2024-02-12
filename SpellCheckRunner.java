import java.util.*;

class SpellCheckRunner {
  public static void main(String[] args) {
    SpellChecker checker = new SpellChecker();
    System.out.print("Enter a word to spell check or q to quit: ");
    Scanner scan = new Scanner(System.in);
    String word = scan.nextLine();
    while (!word.equals("q")) {
      if (checker.spellcheck(word) == true)
        System.out.println(word + " is spelled correctly!");
      else
        System.out.println(word + " is misspelled!");

      System.out.print("Enter a word to spell check or q to quit: ");
      word = scan.nextLine();
      }
    checker.printStartsWith("he");
    checker.print10();
    scan.close();
  }
}