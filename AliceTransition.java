import java.util.ArrayList;
import java.lang.Math;
import java.awt.Color;

public class AliceTransition extends Transition {

    public AliceTransition (Location start, Location end) {
        super(start, end);
    }

    @Override
    public State move(State state) { //checks if end in list of valid transitions and if steps are positive

        int movement = Math.abs(start.getX() - end.getX());
        if (movement == 0) {
            movement = Math.abs(start.getY() - end.getY());
        }
        if (state.currentLocation().equals(start) && movement == state.getSteps().get(state.getSteps().size() - 1)) {
            ArrayList<Location> newLocs = new ArrayList<>(state.getLocs());
            newLocs.add(end);
            State newState = new State(newLocs);
            int newStep = state.getSteps().get(state.getSteps().size() - 1);
            if (end.getColor().equals(Color.RED)) {
                newStep++;
            } else if (end.getColor().equals(Color.YELLOW)) {
                newStep--;
            }
            newState.setSteps(new ArrayList<>(state.getSteps()));
            newState.addStep(newStep);

            return newState;
        }
        return null;
    }


}
