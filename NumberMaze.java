import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumberMaze extends AbstractMaze {
    public NumberMaze() {

        ArrayList<ArrayList<String>> mazeString = ReadFile.addFile("NumberMazeFile");

        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        for (ArrayList<String> list : mazeString) {
            ArrayList<Integer> ints = new ArrayList<>();
            for (String s : list) {
                ints.add(Integer.parseInt(s));
            }
            maze.add(ints);
        }

        //locations
        for (int i = 0; i < maze.size(); i++) {
            ArrayList<Location> where = new ArrayList<>();
            for (int j = 0; j < maze.get(i).size(); j++) {
                Location loc = new Location(j, i);
                if (i == 0 && j == 0) {
                    loc.setLocationType(1);
                } else if (i == maze.size() - 1 && j == maze.get(i).size() - 1) {
                    loc.setLocationType(2);
                }
                where.add(loc);
            }
            getLocs().add(where);
        }

        //transitions
        for (int i = 0; i < getLocs().size(); i++) {
            for (int j = 0; j < getLocs().get(i).size(); j++) {
                int movement = maze.get(i).get(j);
                Location current = getLocs().get(i).get(j);
                current.setText("" + movement);
                int xIncr = j + movement;
                int yIncr = i + movement;
                int xDecr = j - movement;
                int yDecr = i - movement;

                if (xIncr < getLocs().get(i).size()) {
                    current.setTransition(new Transition(current, getLocs().get(i).get(xIncr)));
                }
                if (xDecr >= 0) {
                    current.setTransition(new Transition( current, getLocs().get(i).get(xDecr)));
                }
                if (yIncr < getLocs().size()) {
                    current.setTransition(new Transition(current,getLocs().get(yIncr).get(j)));
                }
                if (yDecr >= 0) {
                    current.setTransition(new Transition(current, getLocs().get(yDecr).get(j)));
                }
            }
        }

        ArrayList<Location> current = new ArrayList<>();
        current.add(getLocs().get(0).get(0));
        currentState = new State(current);
        getCurrentState().addStep(1);
    }

}