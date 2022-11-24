import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Field extends JPanel implements KeyListener {

    int x = 180;
    int y = 10;
    public Field(){
        setBounds(70,20,360,500);
        setPreferredSize(new Dimension(360, 500));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        //Timer timer = new Timer(1000, this);
        //timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.GREEN);
        g2D.drawRect(x,y,30,30);

    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            System.out.println("aaa");
            x = x - 10;
        }

        if(e.getKeyChar() == 'w') {
            System.out.println("aaa");
            y = y - 10;
        }
        if(e.getKeyChar() == 'd') {
            System.out.println("aaa");
            x = x + 10;
        }
        if(e.getKeyChar() == 's') {
            System.out.println("aaa");
            y = y + 10;
        }


        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
