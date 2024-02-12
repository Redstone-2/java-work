import java.util.ArrayList;
import javax.swing.JLabel;
public class Battleship {
    public static void main(String[] args){
        JLabel count = new JLabel();
        count.setText("60");
        board b = new board(count, 30);
        ArrayList<ship> stock = new ArrayList<ship>();
        stock.add(new ship("Carrier",5));
        stock.add(new ship("Battleship",4));
        stock.add(new ship("Destroyer",3));
        stock.add(new ship("Sub",3));
        stock.add(new ship("Patrol",2));
        b.fillBoard(stock);
        b.printBoard();
    }
}
