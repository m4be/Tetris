import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Field extends JPanel implements ActionListener{ //

    int x = 0;
    int y = 20;

    int globX = 0;
    int globY = 0;
    int i;
    int j;

    int currRotation = 0;
    public ArrayList<Integer[][]> shapes = new ArrayList<>();

    JLabel statusBar;
    int score = 0;

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
            {4,3},

            {2,2},{3,2},{4,2},{5,2},

            {3,0},
            {3,1},
            {3,2},
            {3,3},

            {2,1},{3,1},{4,1},{5,1},

            {4,0},
            {4,1},
            {4,2},
            {4,3},


    };
    Integer[][] O = {
            {4,0},{4,1},
            {5,0},{5,1},
    };
    Integer[][] J = {
              {4,0},
              {4,1},
        {3,2},{4,2}

    };
    Integer[][] L = {
          {4,0},
          {4,1},
          {4,2},{5,2}
    };
    Integer[][] Z = {
          {3,0},{4,0},
                {4,1},{5,1}
    };
    Integer[][] S = {
                {4,0},{5,0},
          {3,1},{4,1}



    };
    Integer[][] T = {
            {4,0},
      {3,1},{4,1},{5,1}
    };

    Integer[][] tempShape = new Integer[16][2];

    Integer[][] randomShape(){

        currRotation = 0;
        //shapes.add(O);
        shapes.add(I);
        //shapes.add(J);
        //shapes.add(L);
        //shapes.add(Z);
        //shapes.add(S);
        //shapes.add(T);
        Integer[][] temp = new Integer[4][2];

        int n = (int)(Math.random() * shapes.size());

        for(i = 0; i < 16; i++)
            for(j = 0; j <2 ; j++)
                tempShape[i][j] = shapes.get(n)[i][j];

        for(i = 0; i < 4; i++)
            for(j = 0; j <2 ; j++)
                temp[i][j] = tempShape[i][j];



        return temp;
    }

    void removeLine(int k){

        int[][] tempTable = new int[12][9];
        boolean done = false;
        int offset = 0;
        for(i = 11; i > 0; i--)
            for(j = 0; j < 9; j++)
            {
                if(i == k && !done)
                {
                    tempTable[i][j] = Table[i-1][j];

                    System.out.println(tempTable[i][j]);
                    offset = 1;
                    if(j == 8)
                        done = true;
                }
                else{
                    tempTable[i][j] = Table[i-offset][j];
                }
            }
        Table = tempTable;
    }
    void checkFilledLine(){
        for (int i = 0; i < 12; i++) {
            int cnt = 0;
            for (int j = 0; j < 9; j++) {
                if(Table[i][j] == 2) {
                    cnt++;
                }
                if(cnt == 9) {
                    removeLine(i);
                    statusBar.setText(Integer.toString(score+=1));
                }
            }
        }
    }





    Integer[][] shape;

    public Field(Window parent){
        statusBar = parent.score;
        statusBar.setText(Integer.toString(score));
        setBounds(70,20,360,500);
        setPreferredSize(new Dimension(360, 500));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        setLayout(null);
        setFocusable(true);

        Timer timer = new Timer(1222000,this);
        timer.start();

        shape  = randomShape();
    }

    @Override
    public void paintComponent(Graphics g)
    {

        checkFilledLine();
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.GREEN);
        g2D.drawRect(x + shape[0][0]*40 , y + shape[0][1] * 40,40,40);
        g2D.drawRect(x + shape[1][0]*40 , y + shape[1][1] * 40,40,40);
        g2D.drawRect(x + shape[2][0]*40 , y + shape[2][1] * 40,40,40);
        g2D.drawRect(x + shape[3][0]*40 , y + shape[3][1] * 40,40,40);

        for (i = 0; i < 12; i++) {
            for (j = 0; j < 9; j++) {
                if(Table[i][j] == 2) {
                    g2D.fillRect(x + j * 40, y + i * 40, 40, 40);
                }
            }
        }
    }


    void moveLeft(){
            if(((shape[0][0] - 1) >= 0) && ((shape[1][0] - 1) >= 0) && ((shape[2][0] - 1) >= 0) && ((shape[3][0] - 1) >= 0)) {

                if( !(Table[shape[0][1]][shape[0][0]-1] == 2 ||
                      Table[shape[1][1]][shape[1][0]-1] == 2 ||
                      Table[shape[2][1]][shape[2][0]-1] == 2 ||
                      Table[shape[3][1]][shape[3][0]-1] == 2))
                {
                    shape[0][0] -= 1;
                    shape[1][0] -= 1;
                    shape[2][0] -= 1;
                    shape[3][0] -= 1;
                    globX -=1;
                    repaint();
                }
            }
            else{
                System.out.println("A CANCELED");
            }
        }
    void rotate() {
        for(i = 0; i < 4 ; i++)
            for(j = 0; j < 2 ; j++)
                tempShape[i][j] = shape[i][j];

        for(i = 0; i < 4 ; i++) {
            shape[i][0] = 6 - 1 - tempShape[i][1];
            shape[i][1] = tempShape[i][0] - 3;    //При повыщении Y повышается разброс
        }

        repaint();
    }
        void moveRight(){
            if (((shape[0][0] + 1) < 9) && ((shape[1][0] + 1) < 9) && ((shape[2][0] + 1) < 9) && ((shape[3][0] + 1) < 9)) {
                if (!(Table[shape[0][1]][shape[0][0] + 1] == 2 ||
                        Table[shape[1][1]][shape[1][0] + 1] == 2 ||
                        Table[shape[2][1]][shape[2][0] + 1] == 2 ||
                        Table[shape[3][1]][shape[3][0] + 1] == 2)) {
                    shape[0][0] += 1;
                    shape[1][0] += 1;
                    shape[2][0] += 1;
                    shape[3][0] += 1;
                    globX +=1;
                }
                repaint();
            } else {
                System.out.println("D CANCEL");
            }
        }
        void moveDown (){

            if (((shape[0][1] + 1) < 12) && ((shape[1][1] + 1) < 12) && ((shape[2][1] + 1) < 12) && ((shape[3][1] + 1) < 12)) {
                if (Table[shape[0][1] + 1][shape[0][0]] == 2 ||
                        Table[shape[1][1] + 1][shape[1][0]] == 2 ||
                        Table[shape[2][1] + 1][shape[2][0]] == 2 ||
                        Table[shape[3][1] + 1][shape[3][0]] == 2) {
                    Table[shape[0][1]][shape[0][0]] = 2;
                    Table[shape[1][1]][shape[1][0]] = 2;
                    Table[shape[2][1]][shape[2][0]] = 2;
                    Table[shape[3][1]][shape[3][0]] = 2;

                    shape = randomShape();
                    repaint();

                    //for (i = 0; i < 12; i++) {
                    //    for (j = 0; j < 9; j++) {
                    //        System.out.print("[" + Table[i][j] + "],");
                    //        //Table[i][j] = 0;
                    //    }
                    //    System.out.println("\n");
                    //}

                } else {
                    shape[0][1] += 1;
                    shape[1][1] += 1;
                    shape[2][1] += 1;
                    shape[3][1] += 1;
                    globY +=1;


                    repaint();
                }
            } else {
                System.out.println("S CANCEL");

                Table[shape[0][1]][shape[0][0]] = 2;
                Table[shape[1][1]][shape[1][0]] = 2;
                Table[shape[2][1]][shape[2][0]] = 2;
                Table[shape[3][1]][shape[3][0]] = 2;

                shape = randomShape();
                repaint();
            }
        }

      @Override
        public void actionPerformed (ActionEvent e){
            if (((shape[0][1] + 1) < 12) && ((shape[1][1] + 1) < 12) && ((shape[2][1] + 1) < 12) && ((shape[3][1] + 1) < 12)) {
                if (Table[shape[0][1] + 1][shape[0][0]] == 2 ||
                        Table[shape[1][1] + 1][shape[1][0]] == 2 ||
                        Table[shape[2][1] + 1][shape[2][0]] == 2 ||
                        Table[shape[3][1] + 1][shape[3][0]] == 2)
                {
                    Table[shape[0][1]][shape[0][0]] = 2;
                    Table[shape[1][1]][shape[1][0]] = 2;
                    Table[shape[2][1]][shape[2][0]] = 2;
                    Table[shape[3][1]][shape[3][0]] = 2;
                    shape = randomShape();
                    repaint();

                    //for (i = 0; i < 12; i++) {
                    //    for (j = 0; j < 9; j++) {
                    //        System.out.print("[" + Table[i][j] + "],");
                    //        //Table[i][j] = 0;
                    //    }
                    //    System.out.println("\n");
                    //}

                } else {
                    shape[0][1] += 1;
                    shape[1][1] += 1;
                    shape[2][1] += 1;
                    shape[3][1] += 1;
                    //System.out.println("_______________________");
                    //for (i = 0; i < 12; i++) {
                    //    for (j = 0; j < 9; j++) {
                    //        System.out.print("[" + Table[i][j] + "],");
                    //        //Table[i][j] = 0;
                    //    }
                    //    System.out.println("\n");
                    //}
                    repaint();
                }
            } else {
                Table[shape[0][1]][shape[0][0]] = 2;
                Table[shape[1][1]][shape[1][0]] = 2;
                Table[shape[2][1]][shape[2][0]] = 2;
                Table[shape[3][1]][shape[3][0]] = 2;

                //for (i = 0; i < 12; i++) {
                //    for (j = 0; j < 9; j++) {
                //        System.out.print("[" + Table[i][j] + "],");
                //        //Table[i][j] = 0;
                //    }
                //    System.out.println("\n");
                //}

                shape = randomShape();
                repaint();
            }
        }
}

