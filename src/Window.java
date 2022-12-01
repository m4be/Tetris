import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{ //,KeyListener


    private JLabel score = new JLabel("");
    private JButton newGame = new JButton();
    private JButton about = new JButton();
    private JButton highScores = new JButton();
    private JButton exit = new JButton();

    Field field;

    void Changer(JButton b,int x, int y, int w, int h,String name){
        b.setBounds(x,y,w,h);
        b.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        b.setText(name);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.GREEN);
    }

    void start() {


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

        setFocusable(true);

        field = new Field();
        //addKeyListener(this);




        score.setVerticalAlignment(JLabel.BOTTOM);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        score.setForeground(Color.GREEN);
        score.setBounds(70,530,360,20);

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


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher( new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED) {
                    System.out.println(e.getKeyCode());
                    switch (e.getKeyCode()) {
                        case 37:
                            field.moveLeft();
                            break;
                        case 38:
                            field.rotate();
                            break;
                        case 39:
                            field.moveRight();
                            break;
                        case 40:
                            field.moveDown();
                            break;
                        default:
                            break;
                    }
                }
                return false;
            }
        });



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGame){
            remove(field);
            field = new Field();
            add(field);
        }
        if(e.getSource()==about){

        }
        if(e.getSource()==highScores){

        }
        if(e.getSource()==exit){

        }

    }







}
