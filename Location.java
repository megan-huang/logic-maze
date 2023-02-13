import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.Color;

public class Location {
    private int locationType;
    private String text;
    private Color color = Color.WHITE;

    private ArrayList<Transition> transitions = new ArrayList<>();
    private int x;
    private int y;

    public Location (int x, int y) {
        this.x = x;
        this.y = y;
        this.locationType = 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    void setLocationType(int type) {
        this.locationType = type;
    }

    public int getLocationType() {
        return this.locationType;
    }


    public void setTransition(Transition newTransition) {
        transitions.add(newTransition);
    }

    public ArrayList<Transition> transitions() {
        return transitions;
    }

    public void setText (String text){
        this.text = text;

    }

    public String getText() {
        return this.text;
    }

    public void setColor (Color c) {
        this.color = c;

    }

    public Color getColor() {
        return this.color;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public ArrayList<Transition> getTransitions() {
        return this.transitions;
    }
}
