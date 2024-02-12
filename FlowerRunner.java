//import javax.swing.JFrame;
import java.awt.Color;
public class FlowerRunner {
    public static void main(String[] args){
        Flower one = new Flower("tulup", 1000, new Color(0,0,128));
        Flower two = new Flower("rose", 1000, new Color(128,0,0));
        Flower three = new Flower("daffodil", 500, new Color(255,255,255));
        Flower four = new Flower("dandylion", 600, new Color(255,255,0));
        Flower[] inv = {one, two, three, four};
        FlowerShop test = new FlowerShop(inv);
        System.out.print(test);
        test.draw();        
    }
}
