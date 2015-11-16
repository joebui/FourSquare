public class Game {
    public static void main(String[] args) {
        Model f = new Model();
        View i = new View(f);
        Controller a = new Controller(f, i);

        i.setVisible(true);
    }
}
