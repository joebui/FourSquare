import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Model {
    Cell[][] c = new Cell[12][12];
    private byte mode;
    private byte whoseTurn = 1;
    private String p1Name = "", p2Name = "";
    private String p1Stone = "", p2Stone = "";
    private byte p1S, p2S;

    Image dia1 = new ImageIcon("images/dia1.jpg").getImage().getScaledInstance(51,51,Image.SCALE_SMOOTH);
    Image dia2 = new ImageIcon("images/dia2.jpg").getImage().getScaledInstance(51,51,Image.SCALE_SMOOTH);
    Image dia3 = new ImageIcon("images/dia3.jpg").getImage().getScaledInstance(51,51,Image.SCALE_SMOOTH);
    JLabel p1Score = new JLabel();
    JLabel p2Score = new JLabel();
    JTextField stt = new JTextField();

    public Model() {
        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                c[i][j] = new Cell();
            }
        }

        stt.setEditable(false);
        stt.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    public void setMode(byte m) { mode = m; }

    public void setWhoseTurn(byte t) { whoseTurn = t; }

    public void setP1Name(String n) {
        p1Name = n;
    }

    public void setP2Name(String n) {
        p2Name = n;
    }

    public void setP1Stone(String s) {
        p1Stone = s;
    }

    public void setP2Stone(String s) {
        p2Stone = s;
    }

    public String getP1Name() {
        return p1Name;
    }

    public String getP2Name() {
        return p2Name;
    }

    public String getP1Stone() {
        return p1Stone;
    }

    public String getP2Stone() {
        return p2Stone;
    }

    public boolean isFull() {
        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (c[i][j].getStone() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] activateAI() {
        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (i < c.length - 1 && j < c[i].length - 1) {
                    if (c[i][j].getStone() == 1 && c[i][j + 1].getStone() == 0 && c[i + 1][j].getStone() == 1 &&
                            c[i + 1][j + 1].getStone() == 1) {
                        return new int[] {i, j + 1};
                    } else if (c[i][j].getStone() == 0 && c[i][j + 1].getStone() == 1 && c[i + 1][j].getStone() == 1 &&
                            c[i + 1][j + 1].getStone() == 1) {
                        return new int[] {i, j};
                    } else if (c[i][j].getStone() == 1 && c[i][j + 1].getStone() == 1 && c[i + 1][j].getStone() == 0 &&
                            c[i + 1][j + 1].getStone() == 1) {
                        return new int[] {i + 1, j};
                    } else if (c[i][j].getStone() == 1 && c[i][j + 1].getStone() == 1 && c[i + 1][j].getStone() == 1 &&
                            c[i + 1][j + 1].getStone() == 0) {
                        return new int[] {i + 1, j + 1};
                    }
                }
            }
        }

        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (i < c.length - 1 && j < c[i].length - 1) {
                    if (c[i][j].getStone() == 2 && c[i][j + 1].getStone() == 0 && c[i + 1][j].getStone() == 2 &&
                            c[i + 1][j + 1].getStone() == 2) {
                        return new int[] {i, j + 1};
                    } else if (c[i][j].getStone() == 0 && c[i][j + 1].getStone() == 2 && c[i + 1][j].getStone() == 2 &&
                            c[i + 1][j + 1].getStone() == 2) {
                        return new int[] {i, j};
                    } else if (c[i][j].getStone() == 2 && c[i][j + 1].getStone() == 2 && c[i + 1][j].getStone() == 0 &&
                            c[i + 1][j + 1].getStone() == 2) {
                        return new int[] {i + 1, j};
                    } else if (c[i][j].getStone() == 2 && c[i][j + 1].getStone() == 2 && c[i + 1][j].getStone() == 2 &&
                            c[i + 1][j + 1].getStone() == 0) {
                        return new int[] {i + 1, j + 1};
                    }
                }
            }
        }

        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (i < c.length - 1 && j < c[i].length - 1) {
                    if (j == 0 && c[i][j].getStone() == 2 && c[i + 1][j].getStone() == 2) {
                        if (c[i][1].getStone() == 0) {
                            return new int[] {i, 1};
                        } else if (c[i + 1][1].getStone() == 0) {
                            return new int[] {i + 1, 1};
                        }
                    } else if (j > 0 && c[i][j].getStone() == 2 && c[i + 1][j].getStone() == 2) {
                        if (c[i][j + 1].getStone() == 0) {
                            return new int[] {i, j + 1};
                        } else if (c[i + 1][j + 1].getStone() == 0) {
                            return new int[] {i + 1, j + 1};
                        } else if (c[i][j - 1].getStone() == 0) {
                            return new int[] {i, j - 1};
                        } else if (c[i + 1][j - 1].getStone() == 0) {
                            return new int[] {i + 1, j - 1};
                        }
                    } else if (i == 0 && c[i][j].getStone() == 2 && c[i][j + 1].getStone() == 2) {
                        if (c[1][j].getStone() == 0) {
                            return new int[] {1, j};
                        } else if (c[1][j + 1].getStone() == 0) {
                            return new int[] {1, j + 1};
                        }
                    } else if (i > 0 && c[i][j].getStone() == 2 && c[i][j + 1].getStone() == 2) {
                        if (c[i + 1][j].getStone() == 0) {
                            return new int[] {i + 1, j};
                        } else if (c[i + 1][j + 1].getStone() == 0) {
                            return new int[] {i + 1, j + 1};
                        } else if (c[i - 1][j].getStone() == 0) {
                            return new int[] {i - 1, j};
                        } else if (c[i - 1][j + 1].getStone() == 0) {
                            return new int[] {i - 1, j + 1};
                        }
                    }
                }
            }
        }

        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (i < c.length - 1 && j < c[i].length - 1) {
                    if (i == 0 && j == 0 && c[i][j].getStone() == 2) {
                        if (c[i][j + 1].getStone() == 0) {
                            return new int[]{i, j + 1};
                        } else if (c[i + 1][j].getStone() == 0) {
                            return new int[]{i + 1, j};
                        }
                    } else if (j == 0 && i > 0 && c[i][j].getStone() == 2) {
                        if (c[i][j + 1].getStone() == 0) {
                            return new int[]{i, j + 1};
                        } else if (c[i + 1][j].getStone() == 0) {
                            return new int[]{i + 1, j};
                        } else if (c[i - 1][j].getStone() == 0) {
                            return new int[]{i - 1, j};
                        }
                    } else if (i == 0 && j > 0 && c[i][j].getStone() == 2) {
                        if (c[i][j + 1].getStone() == 0) {
                            return new int[]{i, j + 1};
                        } else if (c[i + 1][j].getStone() == 0) {
                            return new int[]{i + 1, j};
                        } else if (c[i][j - 1].getStone() == 0) {
                            return new int[]{i, j - 1};
                        }
                    } else if (i > 0 && j > 0 && c[i][j].getStone() == 2) {
                        if (c[i][j + 1].getStone() == 0) {
                            return new int[]{i, j + 1};
                        } else if (c[i + 1][j].getStone() == 0) {
                            return new int[]{i + 1, j};
                        } else if (c[i][j - 1].getStone() == 0) {
                            return new int[]{i, j - 1};
                        } else if (c[i - 1][j].getStone() == 0) {
                            return new int[]{i - 1, j};
                        }
                    }
                }
            }
        }
        return randomStone();
    }

    public int[] randomStone() {
        Random r = new Random();
        int i = r.nextInt(12);
        int j = r.nextInt(12);
        if (c[i][j].getStone() == 0) {
            return new int[] {i, j};
        } else {
            return randomStone();
        }
    }

    public void restart() {
        stt.setText("\t\t\t\t" + getP1Name() + "'s turn");
        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                c[i][j].setStone((byte) 0);
            }
        }
        p1Score.setText("0");
        p2Score.setText("0");
        whoseTurn = 1;
    }

    public byte computeScore(byte s) {
        byte score = 0;
        for (byte i = 0; i < c.length; i++) {
            for (byte j = 0; j < c[i].length; j++) {
                if (i < c.length - 1 && j < c[i].length - 1) {
                    if (c[i][j].getStone() == s && c[i][j + 1].getStone() == s && c[i + 1][j].getStone() == s &&
                            c[i + 1][j + 1].getStone() == s) {
                        score++;
                    }
                }
            }
        }
        return score;
    }

    public String winner() {
        int max = Math.max(p1S, p2S);
        if (max == p1S) {
            return p1Name;
        } else if (max == p2S) {
            return p2Name;
        } else {
			return "No one";
		}
    }

    class Cell extends JPanel {
        private byte stone;

        public Cell() {
            setBackground(Color.lightGray);
            setBorder(new LineBorder(Color.black, 1));
            addMouseListener(new PlacingStoneAction());
        }

        public void setStone(byte s) {
            stone = s;
            p1S = computeScore((byte) 1);  p2S = computeScore((byte) 2);
            p1Score.setText(String.valueOf(p1S));
            p2Score.setText(String.valueOf(p2S));
            repaint();
        }

        public byte getStone() {
            return stone;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (stone == 1) {
                if (p1Stone.equals("dia1")) {
                    g.drawImage(dia1,0,0,this);
                } else if (p1Stone.equals("dia2")) {
                    g.drawImage(dia2,0,0,this);
                } else if (p1Stone.equals("dia3")) {
                    g.drawImage(dia3,0,0,this);
                }
            } else if (stone == 2) {
                if (p2Stone.equals("dia1")) {
                    g.drawImage(dia1,0,0,this);
                } else if (p2Stone.equals("dia2")) {
                    g.drawImage(dia2,0,0,this);
                } else if (p2Stone.equals("dia3")) {
                    g.drawImage(dia3,0,0,this);
                }
            }
        }

        class PlacingStoneAction implements MouseListener {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mode == 1) {
                    if (whoseTurn != 0 && stone == 0) {
                        setStone(whoseTurn);
                        whoseTurn = 2;
                        int[] position = activateAI();
                        c[position[0]][position[1]].setStone(whoseTurn);

                        if (isFull()) {
                            whoseTurn = 0;
                            JOptionPane.showMessageDialog(null, "The game is over. " + winner() + " won!!!", "Victory", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            whoseTurn = 1;
                            stt.setText("\t\t\t\t" + p1Name + "'s turn");
                        }
                    }
                } else if (mode == 2) {
                    if (whoseTurn != 0 && stone == 0) {
                        setStone(whoseTurn);
                        if (isFull()) {
                            whoseTurn = 0;
                            JOptionPane.showMessageDialog(null, "The game is over. " + winner() + " won!!!", "Victory",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if (whoseTurn == 1) {
                                whoseTurn = 2;
                                stt.setText("\t\t\t\t" + p2Name + "'s turn");
                            } else if (whoseTurn == 2) {
                                whoseTurn = 1;
                                stt.setText("\t\t\t\t" + p1Name + "'s turn");
                            }
                        }
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }
    }
}
