public class tile{
    public String type= "water";
    public tile(){}
    public tile(String type){this.type = type;}
    public String hit(){
        return "Miss!";
    }
    public String toString(){return "water";}
    public boolean isWater(){return true;}
}
