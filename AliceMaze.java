import java.util.ArrayList;
import java.awt.Color;

public class AliceMaze extends AbstractMaze {

    public AliceMaze() {

        ArrayList<ArrayList<String>> maze = ReadFile.addFile("AliceMazeFile");

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

        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(i).size(); j++) {
                String[] directionsAndColor = maze.get(i).get(j).split(";");
                Location currentLoc = locs.get(i).get(j);
                if (directionsAndColor.length > 1) {
                    currentLoc.setColor(directionsAndColor[1].equals("red") ? Color.RED : Color.YELLOW);
                } else {
                    currentLoc.setColor(Color.WHITE);
                }
                String[] directions = directionsAndColor[0].split(",");
                String text = "";
                for (String d : directions) {
                    int dir = Integer.parseInt(d);
                    int increment = 1;
                    if (dir == 0) {
                        text = text + "↑";
                        while (i - increment >= 0) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i - increment).get(j)));
                            increment++;
                        }
                    } else if (dir == 1) {
                        text = text + "↗";
                        while (i - increment >= 0 && j + increment < getLocs().get(i).size()) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i - increment).get(j + increment)));
                            increment++;
                        }
                    } else if (dir == 2) {
                        text = text + "→";
                        while (j + increment < getLocs().get(i).size()) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i).get(j + increment)));

                            increment++;
                        }
                    } else if (dir == 3) {
                        text = text + "↘";
                        while (i + increment < getLocs().size() && j + increment < locs.get(i).size()) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i + increment).get(j + increment)));
                            increment++;
                        }
                    } else if (dir == 4) {
                        text = text + "↓";
                        while (i + increment < locs.size()) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i + increment).get(j)));
                            increment++;
                        }
                    } else if (dir == 5) {
                        text = text +"↙";
                        while (i + increment < locs.size() && j - increment >= 0) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i + increment).get(j - increment)));
                            increment++;
                        }
                    } else if (dir == 6) {
                        text = text + "←";
                        while (j - increment >= 0) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i).get(j - increment)));
                            increment++;
                        }
                    } else if (dir == 7) {
                        text = text + "↖";
                        while (i - increment >= 0 && j - increment >= 0) {
                            currentLoc.setTransition(new AliceTransition(currentLoc, locs.get(i - increment).get(j - increment)));
                            increment++;
                        }
                    }
                    currentLoc.setText(text);
                }
            }
        }

        ArrayList<Location> current = new ArrayList<>();
        current.add(getLocs().get(0).get(0));
        setCurrentState(new State(current));
        getCurrentState().addStep(1);

    }

}
