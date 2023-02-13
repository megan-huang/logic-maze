import java.util.ArrayList;

public class State {
    protected ArrayList<Location> locs;
    protected ArrayList<Integer> steps = new ArrayList<>(); //store step movement

    public State(ArrayList<Location> locs) {
        this.locs = locs;
    }


    public Location currentLocation() {
        if (locs != null && !locs.isEmpty()) {
            Location current = locs.get(locs.size() - 1);
            return current;
        }
        return null;
    }

    public ArrayList<Location> getLocs() {
        return this.locs;
    }


    public void addStep(int step) {
        steps.add(step);
    }


    public void setSteps(ArrayList<Integer> steps) {
        this.steps = steps;
    }


    public ArrayList<Integer> getSteps() {
        return this.steps;
    }
}
