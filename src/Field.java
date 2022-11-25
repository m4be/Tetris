import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Field extends JPanel implements KeyListener,ActionListener {

    int x = 0;
    int y = 20;
    int i;
    int j;

    int startPositionX = 200;
    int startPositionY = 20;

    public ArrayList<Integer[][]> shapes = new ArrayList<>();



    int[][] Table = new int[][]{
            {0,0,0,0,0,0,0,0,0},  //[0,2]
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };


    Integer[][] I = {
            {4,0},
            {4,1},
            {4,2},
            {4,3}
    };

    Integer[][] O = {
            {4,0},
            {4,1},
            {5,0},
            {5,1}
    };

    Integer[][] J = {
            {4,0},
            {4,1},
            {4,2},
            {3,2}
    };

    Integer[][] L = {
            {4,0},
            {4,1},
            {4,2},
            {5,2}
    };

    Integer[][] Z = {
            {3,0},
            {4,0},
            {4,1},
            {5,1}
    };

    Integer[][] S = {
            {5,0},
            {4,0},
            {4,1},
            {3,1}
    };

    Integer[][] T = {
            {4,0},
            {4,1},
            {3,1},
            {5,1}
    };


    Integer[][] randomShape(){
        //shapes.add(O);
        //shapes.add(I);
        //shapes.add(J);
        //shapes.add(L);
        //shapes.add(Z);
        //shapes.add(S);
        shapes.add(T);
        int n = (int)(Math.random() * shapes.size());
        return shapes.get(n);
    }

    Integer[][] shape = randomShape();

    public Field(){
        setBounds(70,20,360,500);
        setPreferredSize(new Dimension(360, 500));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        Timer timer = new Timer(1000,this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.GREEN);
        g2D.drawRect(x + shape[0][0]*40 , y + shape[0][1] * 40,40,40);
        g2D.drawRect(x + shape[1][0]*40 , y + shape[1][1] * 40,40,40);
        g2D.drawRect(x + shape[2][0]*40 , y + shape[2][1] * 40,40,40);
        g2D.drawRect(x + shape[3][0]*40 , y + shape[3][1] * 40,40,40);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            System.out.println("A");
            x = x - 40;
        }

        if(e.getKeyChar() == 'w') {
            System.out.println("W");
            y = y - 40;
        }
        if(e.getKeyChar() == 'd') {
            System.out.println("D");
            x = x + 40;
        }
        if(e.getKeyChar() == 's') {
            System.out.println("S");
            y = y + 40;
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        y = y + 40;

        System.out.println("_______________________");
        for (i = 0; i < 12; i++){
            for (j = 0; j < 9; j++) {
                System.out.print("[" + Table[i][j] + "],");
            }
            System.out.println("\n");
        }
        repaint();

    }
}
