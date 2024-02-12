import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
public class Flower extends Component{
    private String name;
    private int quantity;
    private Color color = new Color(0,0,0);
    public Flower(){}
    public Flower(String name,int quantity, Color color){
        this.name = name.toLowerCase();
        this.quantity = quantity; 
        this.color = color;
    }
    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    public String toString(){return getName()+": "+getQuantity();}
    public Color getColor(){return color;}
    public void draw(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.add(this);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(0, 255, 0));
        g2d.fillRect(140, 140, 10, 170);

        g2d.setColor(color);
        for(int i = 15; i<=45; i+=15)
            for(int j = 15; j<=45; j+=15)
                g2d.fillOval(100+j, 100+i, 30, 30);
        

        g2d.setColor(new Color(0, 255, 0));
        g2d.fillOval(130, 130, 30, 30);
    }
}
