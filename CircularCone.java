public class CircularCone {
    private double radius = 0, height = 0;
    public CircularCone(){}
    public CircularCone(double radius, double height){
        this.radius = radius;
        this.height = height;
    }
    public double getVolume(){return Math.PI*radius*radius*(height/3);}
    public void setHeight(double height){this.height = height;}
    public void setRadius(double radius){this.radius = radius;}
    public double getHeight(){return height;}
    public double getRadius(){return radius;}
    public String toString(){return "height:"+getHeight()+" radius:"+getRadius()+" volume:"+getVolume();}
}

