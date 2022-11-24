import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{


    private JLabel score = new JLabel("");
    private JButton newGame = new JButton();
    private JButton about = new JButton();
    private JButton highScores = new JButton();
    private JButton exit = new JButton();


    void Changer(JButton b,int x, int y, int w, int h,String name){
        b.setBounds(x,y,w,h);
        b.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        b.setText(name);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.GREEN);
    }

    public Window() {

        int width = 450;
        int height = 600;
        score.setText("0");
        this.setTitle("Bebris");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK); //
        this.setLayout(null);

        Field field = new Field();


        score.setVerticalAlignment(JLabel.BOTTOM);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        score.setForeground(Color.GREEN);
        score.setBounds(70,530,360,20);

       /* newGame.setBounds(3,30,65,30);
        newGame.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        newGame.setText("New Game");
        newGame.setBackground(Color.BLACK);
        newGame.setForeground(Color.GREEN);



        highScores.setBounds(3,70,65,30);
        highScores.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        highScores.setText("Score");
        highScores.setBackground(Color.BLACK);
        highScores.setForeground(Color.GREEN);

        about.setBounds(3,110,65,30);
        about.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        about.setText("About");
        about.setBackground(Color.BLACK);
        about.setForeground(Color.GREEN);

        exit.setBounds(3,150,65,30);
        exit.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        exit.setText("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.GREEN);*/

        Changer(newGame,3,30,65,30,"New Game");
        Changer(highScores,3,70,65,30,"Score");
        Changer(about,3,110,65,30,"About");
        Changer(exit,3,150,65,30,"Exit");

        newGame.addActionListener(this);
        highScores.addActionListener(this);
        about.addActionListener(this);
        exit.addActionListener(this);



        this.add(score);
        this.add(field);
        this.add(newGame);
        this.add(about);
        this.add(highScores);
        this.add(exit);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGame){

        }
        if(e.getSource()==about){

        }
        if(e.getSource()==highScores){

        }
        if(e.getSource()==exit){

        }
    }
}
