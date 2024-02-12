import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Component;
public class SquareRunner {
    public static void main(String[] Args){
        Square test = new Square(10);
        Square test2 = new Square(30, new Color(255,0,255));
        System.out.println(test.equals(test2));
        test.setColor(new Color(255,0,0));
        System.out.println(test.equals(test2));
        System.out.println(test);
        System.out.println(test2);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        panel pan = new panel(new Component[] {test2, test});
        frame.add(pan);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
} 
class panel extends JPanel{
    Component[] in;
    public panel(Component[] in){
        this.in = in;

    }
    public void paintComponent(Graphics g){
        for(Component i : in)
        i.paint(g);
    }
}