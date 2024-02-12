import java.util.Scanner;
public class riddles {
public static void main(String[] args) {
        String again = "y";
        Scanner in = new Scanner(System.in);
        while(again.equals("y")){
            int health = 5;
            again = "";
            System.out.println("Intro and first riddle");
            while(health>0&&!in.nextLine().toLowerCase().equals("res1")){
                health--;
                System.out.println("Incorrect. health: "+health);
            }
            if (health<=0){
                while(!(again.equals("y")||again.equals("n"))){
                System.out.println("You failed. Would you like to play again? [y/n]");
                again = in.nextLine();
                }
                continue;
            }

            System.out.println("second riddle");
            while(health>0&&!in.nextLine().toLowerCase().equals("res2")){
                health--;
                System.out.println("Incorrect. health: "+health);
            }
            if (health<=0){
                while(!(again.equals("y")||again.equals("n"))){
                System.out.println("You failed. Would you like to play again? [y/n]");
                again = in.nextLine();
                }
                continue;
            }

            System.out.println("third riddle");
            while(health>0&&!in.nextLine().toLowerCase().equals("res3")){
                health--;
                System.out.println("Incorrect. health: "+health);
            }
            if (health<=0){
                while(!(again.equals("y")||again.equals("n"))){
                System.out.println("You failed. Would you like to play again? [y/n]");
                again = in.nextLine();
                }
                continue;
            }else{
                while(!(again.equals("y")||again.equals("n"))){
                    System.out.println("You Win! Would you like to play again? [y/n]");
                    again = in.nextLine();
                    }
            }

        }
        in.close();
    }
}
