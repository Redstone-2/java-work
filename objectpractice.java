import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Color;

public class objectpractice {
    public static void main(String[] Args){
        JFrame window = new JFrame();
        window.setSize(300, 400);
        window.setTitle("heiii");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new AlienFaceComponent());
        window.setVisible(true);
    }
}
class AlienFaceComponent extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double head = new Ellipse2D.Double(5, 10, 100, 150);
        g2.draw(head);
        g2.setColor(Color.PINK);
        Rectangle eyes = new Rectangle(25, 70, 15, 15);
        g2.fill(eyes);
        eyes.translate(50, 0);
        g2.fill(eyes);
        Line2D.Double mouth = new Line2D.Double(30, 110, 80, 110);
        g2.setColor(Color.RED);
        g2.draw(mouth);
        g2.setColor(Color.BLUE);
        g2.drawString("I come in PEICEEEESS", 5, 175);
    }
}
