public class ship extends tile{
    public int len;
    private int left;
    public ship(String type, int len){
        super(type);
        this.len = len;
        this.left = len;
    }
    public String hit(){
        left --;
        return ((left>0)? "Hit!" : "Hit! You sunk the " +type +"!");
    }
    public String toString(){return super.type+"-"+len;}
    public boolean isWater(){return false;}
}
