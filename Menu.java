//Megan Huang

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JFrame {

    private Container contentPane;

    public void init() {
        this.setTitle("Maze Games");

        contentPane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(167, 185, 199));

        //adding gif
        JPanel p = new JPanel();
        p.add(new JLabel(new ImageIcon("ezgif.com-gif-maker.gif")));
        p.setBackground(new Color(167, 185, 199));
        contentPane.add(p);

        //maze selection buttons
        JButton jb = new JButton("Number Maze");
        contentPane.add(jb);
        jb.addActionListener(new NumberMazeSelect());
        JButton jb2 = new JButton("Arrow Maze");
        contentPane.add(jb2);
        jb2.addActionListener(new ArrowMazeSelect());
        JButton jb3 = new JButton("Alice Maze");
        contentPane.add(jb3);
        jb3.addActionListener(new AliceMazeSelect());

        JLabel label = new JLabel();
        label.setText("Welcome Challenger");
        label.setForeground(new Color(92, 120, 250));
        label.setFont(new Font("Century Gothic", Font.BOLD, 25));
        this.add(label);
    }

    class NumberMazeSelect implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setVisible(false);

            NumberMaze maze = new NumberMaze();
            GameFrame frame = new GameFrame(maze);
            frame.setUpFrame();
            frame.pack();
            frame.setVisible(true);
            frame.setPreferredSize(new Dimension(700, 600));
            frame.repaint();
        }

    }

    class ArrowMazeSelect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);

            ArrowMaze maze = new ArrowMaze();
            GameFrame frame = new GameFrame(maze);
            frame.setUpFrame();
            frame.pack();
            frame.setVisible(true);
            frame.setPreferredSize(new Dimension(700, 600));
            frame.repaint();
        }
    }

    class AliceMazeSelect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);

            AliceMaze maze = new AliceMaze();
            GameFrame frame = new GameFrame(maze);
            frame.setUpFrame();
            frame.pack();
            frame.setVisible(true);
            frame.setPreferredSize(new Dimension(700,600));
            frame.repaint();
        }
    }


    public static void main(String[] args) {

        Menu thisOne = new Menu();
        thisOne.init();

        thisOne.pack();
        thisOne.setVisible(true);
        thisOne.setSize(new Dimension(900, 480));
    }
}
