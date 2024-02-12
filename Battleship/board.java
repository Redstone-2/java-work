import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.Color;
public class board{

    private tile[][] board;
    private JLabel count;
    private GUIBoard gui;

    public board(JLabel count, int size){
        this.count = count;
        gui = new GUIBoard(size,this, this.count);
        board = new tile[size][size];
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = new tile();
            }
        } 
    }

    public boolean placeShip(ship ship, int row, int col, String direction){
        int len = ship.len;
        if(col + 1 < len && direction.equals("l")) return false;
        if(row + 1 < len && direction.equals("u")) return false;
        if(col + len > 9 && direction.equals("r")) return false;
        if(row + len  > 9 && direction.equals("d")) return false;
        if (!board[row][col].isWater()) return false;
        int mod = ((direction.equals("u") || direction.equals("l"))? -1: 1);
        if(direction.equals("u") || direction.equals("d")){
            for(int i = 0; i<len; i++){
                if(!board[row+(i*mod)][col].isWater())
                    return false;
            }
        } else {
            for(int i = 0; i<len; i++){
                if(!board[row][col+(i*mod)].isWater())
                    return false;
            }
        }
        if(direction.equals("u") || direction.equals("d")){
            for(int i = 0; i<len; i++){
                board[row+(i*mod)][col] = ship;
            }
        } else {
            for(int i = 0; i<len; i++){
                board[row][col+(i*mod)] = ship;
            }
        }
        return true;
    }
    public void printBoard(){
        String str = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                str += board[r][c] +" ";
            }
            System.out.println(str);
            str = "";
        }
    }
    public void fillBoard(ArrayList<ship> stock){
        gui.addStock(stock);
        int len = board[0].length;
        int width = board.length;
        int x, y;
        String direction;
        while(stock.size()>0){
            direction = ((Math.random()>0.5)? ((Math.random()>0.5)? "u":"r"):((Math.random()>0.5)? "l":"d"));
            x = (int)(Math.random()*len);
            y= (int)(Math.random()*width);
            if(placeShip(stock.get(0), y,x,direction)){
                stock.remove(0);
            }
        }
    }
    public boolean launch(int x, int y){
        if(board[y][x].isWater()){ board[y][x] = new tile(); return false;}
        else{board[y][x] = new tile(); return true;}
        
    }
    public tile getTile(int x, int y){
        return board[y][x];
    }
    public boolean isEmpty(){
        for(tile[] row : board){
            for(tile i: row){
                if (i.isWater() == false)
                    return false;
            }
        }
        return true;
    }
    public int[] randShip(){
        int len = board[0].length;
        int width = board.length;
        int x = (int)(Math.random()*len);
        int y= (int)(Math.random()*width);
        for(int row = x; row<width; row++)
            for(int col = y; col<len; col++){
                if(!board[row][col].isWater())
                    return new int[]{col, row};
            }
        for(int row = 0; row<width; row++)
            for(int col = 0; col<len; col++){
                if(!board[row][col].isWater())
                    return new int[]{col, row};
            }
        return new int[]{-1,-1};
    }
    public void sonar(){
        int[] shipLoc = randShip();
        int x = shipLoc[0] + (((Math.random()>0.5)? 1:-1) * (int)(Math.random()*3));
        int y = shipLoc[1] + (((Math.random()>0.5)? 1:-1) * (int)(Math.random()*3));
        int[][] outer = new int[][]{
            {x-2, y-3},{x-1,y-3},{x,y-3},{x+1,y-3},{x+2,y-3},
            {x+3,y-2},{x+3,y-1},{x+3,y},{x+3,y+1},{x+3,y+2},
            {x+2, y+3},{x+1,y+3},{x,y+3},{x-1,y+3},{x-2,y+3},
            {x-3,y+2},{x-3,y+1},{x-3,y},{x-3,y-1},{x-3,y-2}};
        gui.clearColor();
        for(int[] cord: outer){
            if(cord[0]>=0 && cord[1]>=0 && cord[0]<board[0].length && cord[1]<board.length)
                gui.color(cord[0], cord[1], Color.gray);
        }
    }
}
