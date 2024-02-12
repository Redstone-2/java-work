public class MyPollyPractice {
    public static void main(String[] args){
        clothing[] closet = {new clothing(6, "motion"), new top(8, "Hollister"), new tShirt(6, "Hilie", "./images/coolPhoto.png")};
        for(clothing piece : closet)
            System.out.println(piece.willFit(9));
        System.out.println(((tShirt)closet[2]).getDesign());
    }
}
class clothing{
    private int size;
    private String brand;
    public clothing(int size, String brand){
        this.size = size;
        this.brand = brand;
    }
    public boolean willFit(int yourSize){
        if(yourSize < size+5 && yourSize > size-5)
            return true;
        return false;
    }
    public int getSize(){return size;}
    public String getBrand(){return brand;}
}
class top extends clothing{
    public top(int size, String brand){
        super(size, brand);
    }
    public boolean willFit(int yourSize){
        if(yourSize < getSize()+3 && yourSize > getSize()-3)
            return true;
        return false;
    }
}
class tShirt extends top{
    String design; 
    public tShirt(int size, String brand, String design){
        super(size, brand);
        this.design = design;
    }
    public boolean willFit(int yourSize){
        if(yourSize < getSize()+1 && yourSize > getSize()-1)
            return true;
        return false;
    }
    public void setDesign(String in){
        design = in;
    }
    public String getDesign(){
        return design;
    }
}