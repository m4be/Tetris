import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Controller implements ActionListener {

Window window;
Field field;


    public Controller(Window window, Field field){
        this.window = window;
        this.field = field;
        Timer timer = new Timer(1,this);
        timer.start();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED) {
                    switch (e.getKeyCode()) {
                        case 37:
                            field.moveLeft();
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
        if(e.getSource()==window.newGame){
            window.startNewGame();
        }
        else if(e.getSource()==window.about){
            window.showAbout();
        }
        else if(e.getSource()==window.highScores){
            window.showLeaderBoard();
        }
        else if(e.getSource()==window.exit){
            System.exit(0);
        }
        else{
            window.checkGameOver();
        }

    }
}
