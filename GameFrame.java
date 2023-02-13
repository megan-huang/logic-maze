import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class GameFrame extends JFrame {
    AbstractMaze maze;

    public GameFrame(AbstractMaze maze) {
        this.maze = maze;
    }

    private ArrayList<MazeButton> buttons = new ArrayList<>();
    private MazeButton currentButton;

    //creating maze GUI
    public void setUpFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container ct = getContentPane();
        ct.setLayout(new GridLayout(maze.getLocs().size() + 1, 0));

        MazeButton jb; //see MazeButton

        //button creation
        for (int i = 0; i < maze.getLocs().size(); i++) {
            for (int j = 0; j < maze.getLocs().get(i).size(); j++) {

                jb = new MazeButton(maze.getLocs().get(i).get(j), this);

                jb.setText(maze.getLocs().get(i).get(j).getText());
                jb.setFont(new Font("Century Gothic", Font.BOLD, 25));

                jb.setOpaque(true);
                jb.setBorderPainted(false);
                if (i == 0 && j == 0) {
                    jb.setDefaultColor(new Color(34, 63, 92));
                    jb.setBackground(Color.BLACK);
                    currentButton = jb;
                } else if ((i + j) % 2 == 0)
                    jb.setDefaultColor(new Color(34, 63, 92));
                else if ((i + j) % 2 == 1)
                    jb.setDefaultColor(new Color(42, 110, 122));
                jb.setForeground(maze.getLocs().get(i).get(j).getColor());


                ct.add(jb);

                buttons.add(jb);

                if (i == maze.getLocs().size() - 1 && j == maze.getLocs().get(i).size() - 1) {
                    jb.setText("GOAL");
                }

            }
        }

        JButton menu = new JButton("Menu");
        menu.addActionListener(new MenuButton());
        ct.add(menu);

        JButton solution = new JButton("Solution");
        solution.addActionListener(new SolverButton(this));
        ct.add(solution);

        JButton undo = new JButton("Undo Move");
        undo.addActionListener(new UndoButton(this));
        ct.add(undo);


    }

    public void setCurrentButton(MazeButton button) {
        currentButton.useDefaultColor();
        currentButton = button;

        if (currentButton.equals(buttons.get(buttons.size() - 1))) {
            currentButton.setBackground(Color.BLACK);
            done();
        }
    }


    public void undo() {
        if (maze.undo()) {
            currentButton.useDefaultColor();
            Location currentLocation = maze.getCurrentState().currentLocation();
            for (MazeButton b : buttons) {
                if (b.getLoc().equals(currentLocation)) {
                    currentButton = b;
                    currentButton.setBackground(Color.BLACK);
                    break;
                }
            }
        }
    }

    public void solve() {
        ArrayList<Location> solution = maze.solve();
        JFrame popUp = new JFrame();
        String message = "";
        if (solution.isEmpty()) {
            message = "No solution found!";
        } else {
            for (Location l : solution) {
                message = message + "(" + l.getX() + ", " + l.getY() + ") ";
            }
        }
        JOptionPane.showMessageDialog(popUp, message);
    }


    public void done() {
        JFrame popUp = new JFrame();
        String victory = "Congratulations, you beat the game!";
        JOptionPane.showMessageDialog(popUp, victory);

    }

    class UndoButton extends JButton implements ActionListener {
        GameFrame g;

        public UndoButton(GameFrame g) {
            this.g = g;
        }

        public void actionPerformed(ActionEvent e) {
            g.undo();
        }
    }

    class SolverButton implements ActionListener {
        GameFrame g;

        public SolverButton(GameFrame g) {
            this.g = g;
        }

        public void actionPerformed(ActionEvent e) {
            g.solve();
        }
    }


    class MenuButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);

            Menu thisOne = new Menu();
            thisOne.init();

            thisOne.pack();
            thisOne.setVisible(true);
            thisOne.setSize(new Dimension(900, 480));
        }
    }


}


