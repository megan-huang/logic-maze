import java.util.ArrayList;

public class Transition {
    protected Location start;
    protected Location end;

    public Transition(Location start, Location end) { //end is the target location
        this.start = start;
        this.end = end;
    }

    public State move(State state) { //checks if end in list of valid transitions
        if(state.currentLocation().equals(start)) {
            ArrayList <Location> newLocs = new ArrayList<>(state.getLocs());
            newLocs.add(end);
            State newState = new State(newLocs);
            newState.setSteps(new ArrayList<>(state.getSteps()));
            newState.addStep(1);
            return newState;
        }
        return null;

    }

}
