import java.awt.Component;
public class Rectangle extends Shape{
    private int len;
    private int width;
    public static void main(String[] args){
        Shape[] shapearray = {new Shape(), new Rectangle(2, 4), new Triangle(4, 3)};
        for(Shape i : shapearray) System.out.println(i.toString());
    }
    public Rectangle(int width, int len){
        super();
        this.len = len;
        this.width = width;
    }
    public double getArea(){
        return width * len;
    }
    public String toString(){
        return "A rectangle with length: "+len+", width: "+width+", area: "+getArea();
    }
}
class Shape extends Component {
    public Shape(){}
    public double getArea(){ return 0.0;}
    public String toString(){return "A shape";}
}
class Triangle extends Shape{
    private int base;
    private int height;
    public Triangle(int base, int height){
        super();
        this.base = base; this. height = height;
    }
    public double getArea(){return base*height*0.5;}
    public String toString(){return "Triangle with height: "+height+", base: "+base+", area: "+getArea();}
}