import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.Position;

public class Interface extends JFrame {
    private Functions f;

    Image d1 = new ImageIcon("images/dia1.jpg").getImage();
    Image d2 = new ImageIcon("images/dia2.jpg").getImage();
    Image d3 = new ImageIcon("images/dia3.jpg").getImage();
    ImageIcon dia1 = new ImageIcon(d1.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    ImageIcon dia2 = new ImageIcon(d2.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    ImageIcon dia3 = new ImageIcon(d3.getScaledInstance(25, 25, Image.SCALE_SMOOTH));

    JPanel menu = new JPanel(new GridLayout(2,0,0,10));
    JButton one = new JButton("1 Player");
    JButton two = new JButton("2 Players");
    JButton exit = new JButton("Exit");

    JPanel namepic = new JPanel(new GridLayout(3,0));
    JTextField name1 = new JTextField(10);
    JTextField name2 = new JTextField(10);
    JButton n1p1 = new JButton(dia1);
    JButton n1p2 = new JButton(dia2);
    JButton n1p3 = new JButton(dia3);
    JButton n2p1 = new JButton(dia1);
    JButton n2p2 = new JButton(dia2);
    JButton n2p3 = new JButton(dia3);
    JButton ok = new JButton("OK");

    JPanel game = new JPanel(new BorderLayout(2,2));
    JButton restart = new JButton("Restart");
    JButton rule = new JButton("Rule");
    JPanel p1Info = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JPanel p2Info = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JButton quit = new JButton("Quit game");

    public Interface(Functions f) {
        this.f = f;
        JLabel title = new JLabel("FourSquare");
        title.setFont(new Font("ALGERIAN", Font.BOLD, 26));
        title.setForeground(Color.black);
        Font menuFont = new Font("Arial", Font.BOLD, 14);

        one.setBackground(Color.white);
        one.setFont(menuFont);
        two.setBackground(Color.white);
        two.setFont(menuFont);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        exit.setFont(menuFont);

        n1p1.setBackground(Color.white);
        n1p2.setBackground(Color.white);
        n1p3.setBackground(Color.white);
        n2p1.setBackground(Color.white);
        n2p2.setBackground(Color.white);
        n2p3.setBackground(Color.white);
        ok.setBackground(Color.white);

        restart.setBackground(Color.white);
        rule.setBackground(Color.white);
        p1Info.setBackground(Color.green);
        p2Info.setBackground(Color.green);
        quit.setBackground(Color.white);

        /******** Main Menu ***********/

        menu.setBackground(Color.green);
        menu.add(title);

        JPanel label = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        label.setBackground(Color.green);
        label.add(title);
        menu.add(label);

        JPanel menuChoice = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        menuChoice.setBackground(Color.green);
        menuChoice.add(one);  menuChoice.add(two);  menuChoice.add(exit);
        menu.add(menuChoice);

        /********** Name and Picture ***********/

        namepic.setBackground(Color.green);

        JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        name.setBackground(Color.green);
        name.add(new JLabel("Player 1's name"));
        name.add(name1);
        name.add(new JLabel("               "));
        name.add(new JLabel("Player 2's name"));
        name.add(name2);
        namepic.add(name);

        JPanel pic = new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
        pic.setBackground(Color.green);
        pic.add(new JLabel("Player 1's picture"));
        pic.add(new JLabel("     "));
        pic.add(n1p1);
        pic.add(n1p2);
        pic.add(n1p3);
        pic.add(new JLabel("                  "));
        pic.add(new JLabel("Player 2's picture"));
        pic.add(new JLabel("     "));
        pic.add(n2p1);
        pic.add(n2p2);
        pic.add(n2p3);
        namepic.add(pic);

        JPanel okButton = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        okButton.setBackground(Color.green);
        okButton.add(ok);
        namepic.add(okButton);

        /********** Game ***********/

        game.setBackground(Color.green);

        JPanel board = new JPanel(new GridLayout(12,12));
        board.setBackground(Color.green);
        for (byte i = 0; i < f.c.length; i++) {
            for (byte j = 0; j < f.c[i].length; j++) {
                board.add(f.c[i][j]);
            }
        }
        game.add(board, BorderLayout.CENTER);

        JPanel gameMenu = new JPanel(new GridLayout(4,0));
        gameMenu.setBackground(Color.green);

        JPanel resPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        resPanel.setBackground(Color.green);
        resPanel.add(restart);
        gameMenu.add(resPanel);
        JPanel rulePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        rulePanel.setBackground(Color.green);
        rulePanel.add(rule);
        gameMenu.add(rulePanel);
        JPanel ss = new JPanel(new GridLayout(2,0,5,10));
        ss.setBackground(Color.green);
        ss.add(p1Info); ss.add(p2Info);
        gameMenu.add(ss);
        JPanel quitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        quitPanel.setBackground(Color.green);
        quitPanel.add(quit);
        gameMenu.add(quitPanel);
        game.add(gameMenu, BorderLayout.EAST);

        game.add(f.stt, BorderLayout.NORTH);

        add(menu);
        setSize(350, 150);
        setTitle("Main Menu - FourSquare");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setP1Info(String img, String name) {
        if (img.equals("dia1")) {
            p1Info.add(new JLabel(dia1));
        } else if (img.equals("dia2")) {
            p1Info.add(new JLabel(dia2));
        } else if (img.equals("dia3")) {
            p1Info.add(new JLabel(dia3));
        }

        p1Info.add(new JLabel(name + ":"));
        f.p1Score.setText("0");
        p1Info.add(f.p1Score);
    }

    public void setP2Info(String img, String name) {
        if (img.equals("dia1")) {
            p2Info.add(new JLabel(dia1));
        } else if (img.equals("dia2")) {
            p2Info.add(new JLabel(dia2));
        } else if (img.equals("dia3")) {
            p2Info.add(new JLabel(dia3));
        }

        p2Info.add(new JLabel(name + ":"));
        f.p2Score.setText("0");
        p2Info.add(f.p2Score);
    }

    public void addActions(ActionListener l) {
        one.addActionListener(l);
        two.addActionListener(l);
        exit.addActionListener(l);

        n1p1.addActionListener(l);
        n1p2.addActionListener(l);
        n1p3.addActionListener(l);
        n2p1.addActionListener(l);
        n2p2.addActionListener(l);
        n2p3.addActionListener(l);
        ok.addActionListener(l);

        restart.addActionListener(l);
        rule.addActionListener(l);
        quit.addActionListener(l);
    }
}
