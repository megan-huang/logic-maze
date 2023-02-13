import java.awt.Color;
import java.util.ArrayList;

public abstract class AbstractMaze {
    protected ArrayList<ArrayList<Location>> locs = new ArrayList<>();
    protected State currentState;

    public boolean tryToMove(Location l) {
        for (Transition t : currentState.currentLocation().transitions()) {
            State newState = t.move(currentState);
            if (newState != null && newState.currentLocation().equals(l)) {
                currentState = newState;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Location> solve() {
        //solves from current location
        ArrayList<Location> currentLoc = new ArrayList<Location>();
        currentLoc.add(currentState.currentLocation());
        State newState = new State(currentLoc);
        ArrayList<Integer> steps = new ArrayList<>();
        steps.add(currentState.getSteps().get(currentState.getSteps().size() - 1));
        newState.setSteps(steps);
        Solver solver = new Solver(newState);
        return solver.solve();
    }


    public boolean undo() {
        if (currentState.getLocs().size() <= 1) {
            return false;
        }
        currentState.getLocs().remove(currentState.getLocs().size() - 1);
        currentState.getSteps().remove(currentState.getSteps().size() - 1);
        return true;

    }

    public ArrayList<ArrayList<Location>> getLocs() {
        return locs;
    }

    public void setLocs(ArrayList<ArrayList<Location>> locs) {
        this.locs = locs;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

}


