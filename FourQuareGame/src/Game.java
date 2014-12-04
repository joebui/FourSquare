import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        Functions f = new Functions();
        Interface i = new Interface(f);
        Actions a = new Actions(f, i);

        i.setVisible(true);
    }
}
