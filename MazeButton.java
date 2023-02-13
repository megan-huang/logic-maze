import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class MazeButton extends JButton implements ActionListener {
    private Location loc;
    private GameFrame g;
    private Color defaultColor = new Color(0, 0, 0);

    public MazeButton(Location l, GameFrame g) {
        setPreferredSize(new Dimension(300, 300));
        this.g = g;
        loc = l;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (g.maze.tryToMove(loc)) {
            setBackground(Color.BLACK);
            g.setCurrentButton(this);
        }
    }

    public void setDefaultColor(Color color) {
        defaultColor = color;
        useDefaultColor();
    }

    public void useDefaultColor() {
        setBackground(defaultColor);
    }

    public Location getLoc() {
        return loc;
    }

}
