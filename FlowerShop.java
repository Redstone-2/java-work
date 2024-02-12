import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class FlowerShop extends Component {
    private Flower[] flowerInventory;
    public FlowerShop(Flower[] inventory){
        Flower[] in = new Flower[inventory.length];
        for(int i = 0; i< inventory.length; i++)
            in[i] = inventory[i];
        Flower temp;
        int n = in.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (in[i].getName().compareTo(in[j].getName()) > 0) {
                    temp = in[i];
                    in[i] = in[j];
                    in[j] = temp;
                }
            }
        }
        flowerInventory = inventory;
    }
    public Flower[] sortByQuantity(Flower[] toSort){
        Flower[] in = new Flower[toSort.length];
        for(int i = 0; i< toSort.length; i++)
            in[i] = toSort[i];
        Flower temp;
        int n = in.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (in[i].getQuantity()<in[j].getQuantity()) {
                    temp = in[i];
                    in[i] = in[j];
                    in[j] = temp;
                    System.out.println(java.util.Arrays.toString(in));
                }
            }
        }
        return in;
    }
    public String toString(){
        String out ="";
        for(Flower i : flowerInventory)
            out += i+"; ";
        return out;
    }
    public void updateInventory(Flower[] newInventory){
        for(int i = 0; i<newInventory.length; i++)
            flowerInventory[i].setQuantity(newInventory[i].getQuantity() + flowerInventory[i].getQuantity());
        
    }
    public boolean topNSame(int n, Flower[] otherInventory){
        Flower[] current = sortByQuantity(flowerInventory);
        otherInventory = sortByQuantity(otherInventory);
        for(int i = 0; i< n; i++){
            if(current[i].getName().equals(current[i].getName()))
                return true;
        }
        return false;
    }
    public void draw(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        int rowlen = ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()) / 80;

        int flowerammount = flowerInventory.length;
        for(Flower i : flowerInventory){

            flowerammount += i.getQuantity()/100 + ((i.getQuantity()%100==0)? 0:1) -1;
        }
        int columnlen = flowerammount/rowlen + ((flowerammount%rowlen == 0)? 0:1);
        int sizex = (flowerammount < rowlen)? flowerammount*80+90:(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        frame.setSize(sizex
        ,90+(columnlen*80));
        frame.add(this);
        frame.setVisible(true);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int rowlen = ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()) / 80;
        int flowerammount = flowerInventory.length;
        for(Flower i : flowerInventory){

            flowerammount += i.getQuantity()/100 + ((i.getQuantity()%100==0)? 0:1) -1;
        }
        int columnlen = flowerammount/rowlen + ((flowerammount%rowlen == 0)? 0:1) + 1;
        int invindex = 0;
        int bunchammount = flowerInventory[invindex].getQuantity()/100 + ((flowerInventory[invindex].getQuantity()%100 == 0)? 0:1) -1;

        for (int columnloc = 0; columnloc<columnlen; columnloc++){
            for(int rowloc = 0; rowloc<rowlen; rowloc++){
                g2d.setColor(new Color(0, 255, 0));
                g2d.fillRect(55+(rowloc*80), 55+(columnloc*80), 10, 170);
        
                g2d.setColor(flowerInventory[invindex].getColor());
                for(int yloc = 15; yloc<=45; yloc+=15)
                    for(int xloc = 15; xloc<=45; xloc+=15)
                        g2d.fillOval(15+(rowloc*80)+xloc, 15+(columnloc*80)+yloc, 30, 30);
                
        
                g2d.setColor(new Color(0, 255, 0));
                g2d.fillOval(45+(rowloc*80), 45+(columnloc*80), 30, 30);
                if(bunchammount == 0){
                    invindex++; 
                    if(invindex>=flowerInventory.length){return;}
                    bunchammount = flowerInventory[invindex].getQuantity()/100 + ((flowerInventory[invindex].getQuantity()%100 == 0)? 0:1) -1;
                }
                else bunchammount--;
            }
        }
    }
}