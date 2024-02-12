import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Square extends Component{
    private int sideLength = 0;
    private Color color = new Color(0,0,0);

    public Square(){}
    public Square(int sideLength){this.sideLength = sideLength;}
    public Square(int sideLength, Color color){this.sideLength = sideLength; setColor(color);}
    public int getSideLength(){return sideLength;}
    public void setSideLength(int sideLength){this.sideLength = sideLength;}
    public void setColor(Color color){this.color = color;}
    public String getColor(){return color.toString();}
    public String toString(){ return "SideLength: "+getSideLength()+" color: "+getColor();}
    public int getPerimeter(){return sideLength*4;}
    public int getArea(){return sideLength*sideLength;}
    public boolean equals(Square that){
        return toString().equals(that.toString());
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.fillRect(0, 0, sideLength, sideLength);
    }

}
