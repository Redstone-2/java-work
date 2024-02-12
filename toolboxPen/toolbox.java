package toolboxPen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class toolbox extends JFrame{
    private static String[] btns = {"Port Scan", "Terminal", "DOS", "NetCat", "Decryption", "Other"};    
    private static String[] imgs = {"scanner.png","terminal.png","dos.png","netcat.png","scanner.png","scanner.png"};
    private ArrayList<JPanel> pages = new ArrayList<JPanel>();
    public toolbox(){
        JPanel p = new JPanel(new GridLayout(2,3));
        for (int i = 0 ; i < 6; i++){
            JPanel btnmargin = new JPanel(new FlowLayout());
            JPanel btnvtr = new JPanel();
            btnvtr.setLayout(new BoxLayout(btnvtr, BoxLayout.Y_AXIS));
            String rowColInfo = btns[i];
            JButton jb = new JButton(rowColInfo);
            try {
                BufferedImage img = ImageIO.read(getClass().getResource("icons/"+imgs[i]));
                Image scaledimg = img.getScaledInstance(70, 70, img.SCALE_DEFAULT);
                
                jb.setIcon(new ImageIcon(scaledimg));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        
            jb.setActionCommand(Integer.toString(i));
        
            jb.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                processClick(jb);
                }});
            btnvtr.add(Box.createRigidArea(new Dimension(0, 30)));
            btnvtr.add(jb);  
            btnmargin.add(btnvtr);   
            p.add(btnmargin);
        }

        JPanel info = new JPanel(new FlowLayout());

        JLabel title = new JLabel("  -Pentest Toolbox-  ");
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        info.add(title);
        JButton jb = new JButton("Check installs");
        jb.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                installCheck(jb);
            }});
        info.add(jb);
        info.setPreferredSize(new Dimension(1,50));

        
        JPanel header = new JPanel(new BorderLayout());
        header.add(info, BorderLayout.NORTH);

        JPanel mainFrame = new JPanel(new BorderLayout());
        mainFrame.add(p, BorderLayout.CENTER);
        mainFrame.add(header, BorderLayout.NORTH);
        Container c= getContentPane();
        setTitle("Pentest Toolbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,645,370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.add(mainFrame);
        setVisible(true);
    }

    public void processClick(JButton jb){
    switch(jb.getActionCommand()){
        case"0":

        break;
        case "1":
        try
        {
        Process run = Runtime.getRuntime().exec(new String[] {"nmap","-h"});
        BufferedReader stdInput = new BufferedReader(new 
        InputStreamReader(run.getInputStream()));

        BufferedReader stdError = new BufferedReader(new 
        InputStreamReader(run.getErrorStream()));

        // Read the output from the command
        String s = stdInput.readLine();
        while (s != null) {
        System.out.println(s);
        s = stdInput.readLine();
        }
        stdInput.close();
        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        s = stdError.readLine();
        while (s != null) {
        System.out.println(s);
        s = stdError.readLine();
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        break;
    }
    }
    public void installCheck(JButton jb){

    }
}