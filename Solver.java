import java.util.ArrayList;

public class Solver {

    private ArrayList<State> states = new ArrayList<>();

    public Solver(State start) {
        states.add(start);
    }

    public ArrayList<Location> solve() {
        while (!states.isEmpty()) {
            State currentState = states.remove(0); //breadth first search
            if (currentState.currentLocation().getLocationType() == 2) {
                return currentState.getLocs();
            }
            for (Transition t : currentState.currentLocation().getTransitions()) {
                State newState = t.move(currentState);
                if (newState != null) {
                    boolean valid = true;
                    for (int i = 0; i < currentState.getLocs().size(); i++) {
                        if (currentState.getLocs().get(i).equals(newState.currentLocation())
                                && currentState.getSteps().get(i).equals(newState.getSteps().
                                get(newState.getSteps().size() - 1))) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        states.add(newState);
                    }
                }
            }
        }
        return new ArrayList<Location>();
    }

}


