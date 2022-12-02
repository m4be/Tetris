import javax.swing.*;

public class Tetris {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Window();
            }
        });
    }
}
