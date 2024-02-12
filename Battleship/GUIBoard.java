import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GUIBoard extends JFrame{
    private static String[] letter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private board board;
    private JLabel count;
    private JLabel resp = new JLabel("");
    private JLabel shipStock = new JLabel("");
    private JButton[] buttons; 
    public GUIBoard(int dimension, board board, JLabel count){
        this.board=board;   
        this.count = count;
        
        JPanel p = new JPanel(new GridLayout(dimension,dimension));
        
        buttons = new JButton[dimension * dimension];
        for (int i = 0 ; i < dimension * dimension; i++){
        String rowColInfo = (letter[(i/dimension)%26]) + ((i % dimension)+1);
        JButton jb = new JButton(rowColInfo);
    
        jb.setActionCommand((i/dimension) +"~"+ (i % dimension));
    
        jb.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            processClick(jb);
            }});
        jb.setBackground(new Color(51, 204, 255));      
        p.add(jb);
        buttons[i] = jb;
        }

        JPanel info = new JPanel(new FlowLayout());
        resp.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(resp);
        JLabel title = new JLabel("  -Battleship-  ");
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(title);
        JLabel label = new JLabel("Shots Left:");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(label);
        count.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(count);
        JLabel sonar = new JLabel("    ");
        info.add(sonar);
        JButton jb = new JButton("Sonar");
        jb.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                sonarTrigger(jb);
            }});
        info.add(jb);
        info.setPreferredSize(new Dimension(1,50));

        JPanel stock = new JPanel(new FlowLayout());
        stock.add(new JLabel("Ships Left: "));
        stock.add(shipStock);
        
        JPanel header = new JPanel(new BorderLayout());
        header.add(info, BorderLayout.NORTH);
        header.add(stock, BorderLayout.CENTER);

        JPanel mainFrame = new JPanel(new BorderLayout());
        mainFrame.add(p, BorderLayout.CENTER);
        mainFrame.add(header, BorderLayout.NORTH);
        Container c= getContentPane();
        setTitle("Battleship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,645,470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.add(mainFrame);
        setVisible(true);
    }

    public void addStock(ArrayList<ship> ships){
        for(int i = 0; i< ships.size(); i++){
            System.out.print(ships.get(i).toString() + ", ");
            shipStock.setText(shipStock.getText() + ships.get(i).toString() + ", ");
        }
    }
    
    public void processClick(JButton jb){
        if(Integer.parseInt(count.getText())>0){
            String res = jb.getActionCommand();
            tile target = board.getTile(Integer.parseInt(res.substring(res.indexOf("~")+1)), Integer.parseInt(res.substring(0, res.indexOf("~"))));
            System.out.println(target.toString());
            String hitres = target.hit();
            if(hitres.indexOf("sunk")>0){
                shipStock.setText(
                    shipStock.getText().substring(0, shipStock.getText().indexOf(target.toString()))
                    +
                    shipStock.getText().substring(shipStock.getText().indexOf(target.toString())+target.toString().length()+1));
            }
            resp.setText(hitres);
            if(board.launch(Integer.parseInt(res.substring(res.indexOf("~")+1)), Integer.parseInt(res.substring(0, res.indexOf("~"))))){
                jb.setBackground(Color.red);
            }else {
                jb.setBackground(Color.white);
            }
            count.setText((Integer.parseInt(count.getText())-1)+"");
            jb.setEnabled(false);
        }
        if(board.isEmpty()){
            System.out.print("win");
            win();
        }else if(Integer.parseInt(count.getText())==0){
            System.out.print("show");
            showShips();
        }
    }
    public void sonarTrigger(JButton jb){
        if(Integer.parseInt(count.getText())>3 && !resp.getText().equals("You Win!")){
            board.sonar();
            count.setText(""+(Integer.parseInt(count.getText())-3));
        }
    }
    
    public void showShips(){
        for(int i = 0; i<buttons.length; i++){
            String res = buttons[i].getActionCommand();
            if(board.launch(Integer.parseInt(res.substring(res.indexOf("~")+1)), Integer.parseInt(res.substring(0, res.indexOf("~"))))){
                buttons[i].setBackground(Color.green);
            }else if(!(buttons[i].getBackground() == Color.red)){
                buttons[i].setBackground(Color.white);
            }
            buttons[i].setEnabled(false);
            resp.setText("You Lost!");
        }
    }

    public void win(){
        for(int i = 0; i<buttons.length; i++){
            buttons[i].setEnabled(false);
            if(!(buttons[i].getBackground() == Color.red)) buttons[i].setBackground(Color.white);
        }
        resp.setText("You Win!");
    }

    public void clearColor(){
        for(int i = 0; i<buttons.length; i++){
            if(!buttons[i].getBackground().equals(Color.red)){
                if(buttons[i].isEnabled()){
                    buttons[i].setBackground(new Color(51, 204, 255));
                }else{
                    buttons[i].setBackground(Color.white);
                }
            }
        }
    }

    public void color(int x, int y, Color color){
        String comm;
        for(int i = 0; i < buttons.length; i++){
            comm = buttons[i].getActionCommand();
            if((Integer.parseInt(comm.substring(comm.indexOf("~")+1)) == x) &&
            (Integer.parseInt(comm.substring(0, comm.indexOf("~")))==y)){
                buttons[i].setBackground(color);
                return;
            }

        }
    }
}