import javax.swing.*;
import java.awt.event.*;

public class Actions {
    private Functions f;
    private Interface i;

    public Actions(Functions f, Interface i) {
        this.f = f;
        this.i = i;

        this.i.addActions(new ButtonActions());
    }

    class ButtonActions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == i.one) {
                f.setMode((byte) 1);
                i.menu.setVisible(false);
                i.namepic.setVisible(true);
                i.add(i.namepic);
                i.setSize(740, 230);
                i.setTitle("Name & Stone - FourSquare");
                i.setLocationRelativeTo(null);
                i.name2.setText("Computer");
                i.name2.setEditable(false);
            } else if (e.getSource() == i.two) {
                f.setMode((byte) 2);
                i.menu.setVisible(false);
                i.namepic.setVisible(true);
                i.add(i.namepic);
                i.setSize(740, 230);
                i.setTitle("Name & Stone - FourSquare");
                i.setLocationRelativeTo(null);

            } else if (e.getSource() == i.n1p1) {
                f.setP1Stone("dia1");
                i.n1p2.setVisible(false);
                i.n1p3.setVisible(false);
                i.n2p1.setVisible(false);
            } else if (e.getSource() == i.n1p2) {
                f.setP1Stone("dia2");
                i.n1p1.setVisible(false);
                i.n1p3.setVisible(false);
                i.n2p2.setVisible(false);
            } else if (e.getSource() == i.n1p3) {
                f.setP1Stone("dia3");
                i.n1p2.setVisible(false);
                i.n1p1.setVisible(false);
                i.n2p3.setVisible(false);
            } else if (e.getSource() == i.n2p1) {
                f.setP2Stone("dia1");
                i.n2p2.setVisible(false);
                i.n2p3.setVisible(false);
                i.n1p1.setVisible(false);
            } else if (e.getSource() == i.n2p2) {
                f.setP2Stone("dia2");
                i.n2p1.setVisible(false);
                i.n2p3.setVisible(false);
                i.n1p2.setVisible(false);
            } else if (e.getSource() == i.n2p3) {
                f.setP2Stone("dia3");
                i.n2p2.setVisible(false);
                i.n2p1.setVisible(false);
                i.n1p3.setVisible(false);
            } else if (e.getSource() == i.ok) {
                f.setP1Name(i.name1.getText());
                f.setP2Name(i.name2.getText());
                if (f.getP1Name().equals("") || f.getP2Name().equals("") || f.getP1Stone().equals("") || f.getP2Stone().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter 2 players' names and choose stone\n   for each player before continuing",
                            "Name & Stone", JOptionPane.ERROR_MESSAGE);
                } else {
                    i.setP1Info(f.getP1Stone(), f.getP1Name());
                    i.setP2Info(f.getP2Stone(), f.getP2Name());
                    f.stt.setText("\t\t\t\t" + f.getP1Name() + "'s turn");
                    i.n1p1.setVisible(true);
                    i.n1p2.setVisible(true);
                    i.n1p3.setVisible(true);
                    i.n2p1.setVisible(true);
                    i.n2p2.setVisible(true);
                    i.n2p3.setVisible(true);
                    i.name1.setText("");
                    i.name2.setText(""); i.name2.setEditable(true);

                    i.namepic.setVisible(false);
                    i.game.setVisible(true);
                    i.add(i.game);
                    i.setSize(770, 680);
                    i.setTitle(f.getP1Name() + " vs " + f.getP2Name() + " - FourSquare");
                    i.setLocationRelativeTo(null);
                }
            } else if (e.getSource() == i.restart) {
                f.restart();
            } else if (e.getSource() == i.rule) {
                JOptionPane.showMessageDialog(null, "In this game, you have to place 4 stones next to each other to create " +
                        "a SQUARE.\nEach time a square is created, the player's point will increase by 1.\nWhen the board is " +
                        "full, the player with the highest score will be the winner.");
            } else if (e.getSource() == i.quit) {
                f.restart();
                f.setWhoseTurn((byte) 1);
                i.p1Info.removeAll(); i.p2Info.removeAll();

                i.game.setVisible(false);
                i.menu.setVisible(true);
                i.add(i.menu);
                i.setSize(350, 150);
                i.setTitle("Main Menu - FourSquare");
                i.setLocationRelativeTo(null);
            } else if (e.getSource() == i.exit) {
                System.exit(0);
            }
        }
    }
}
