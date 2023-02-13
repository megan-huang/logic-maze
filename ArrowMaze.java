
import java.util.ArrayList;
import java.awt.Color;

public class ArrowMaze extends AbstractMaze {
    public ArrowMaze() {

        ArrayList<ArrayList<String>> mazeString = ReadFile.addFile("ArrowMazeFile");

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
                int direction = movement / 2;
                int color = movement % 2; // red = 0
                Location currentLoc = getLocs().get(i).get(j);

                currentLoc.setColor(color == 0 ? Color.RED : new Color(109, 162, 237));

                int increment = 1;
                if (direction == 0) {
                    currentLoc.setText("↑");
                    while (i - increment >= 0) {
                        if (maze.get(i - increment).get(j) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i - increment).get(j)));

                        }
                        increment++;
                    }
                } else if (direction == 1) {
                    currentLoc.setText("↗");
                    while (i - increment >= 0 && j + increment < getLocs().get(i).size()) {
                        if (maze.get(i - increment).get(j + increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i - increment).get(j + increment)));

                        }
                        increment++;
                    }
                } else if (direction == 2) {
                    currentLoc.setText("→");
                    while (j + increment < getLocs().get(i).size()) {
                        if (maze.get(i).get(j + increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i).get(j + increment)));

                        }
                        increment++;
                    }
                } else if (direction == 3) {
                    currentLoc.setText("↘");
                    while (i + increment < getLocs().size() && j + increment < getLocs().get(i).size()) {
                        if (maze.get(i + increment).get(j + increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i + increment).get(j + increment)));

                        }
                        increment++;
                    }
                } else if (direction == 4) {
                    currentLoc.setText("↓");
                    while (i + increment < getLocs().size()) {
                        if (maze.get(i + increment).get(j) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i + increment).get(j)));

                        }
                        increment++;
                    }
                } else if (direction == 5) {
                    currentLoc.setText("↙");
                    while (i + increment < getLocs().size() && j - increment >= 0) {
                        if (maze.get(i + increment).get(j - increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i + increment).get(j - increment)));

                        }
                        increment++;
                    }
                } else if (direction == 6) {
                    currentLoc.setText("←");
                    while (j - increment >= 0) {
                        if (maze.get(i).get(j - increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc, getLocs().get(i).get(j - increment)));

                        }
                        increment++;
                    }
                } else if (direction == 7) {
                    currentLoc.setText("↖");
                    while (i - increment >= 0 && j - increment >= 0) {
                        if (maze.get(i - increment).get(j - increment) % 2 != color) {
                            currentLoc.setTransition(new Transition(currentLoc,getLocs().get(i - increment).get(j - increment)));

                        }
                        increment++;
                    }
                }

            }
        }

        ArrayList<Location> current = new ArrayList<>();
        current.add(getLocs().get(0).get(0));
        currentState = new State(current);
        getCurrentState().addStep(1);
    }

}
