public class Reward {
    private String name;
    private int cost;      // hur många poäng krävs
    private boolean unlocked;

    public Reward(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.unlocked = false;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unlock() {
        this.unlocked = true;
    }

    @Override
    public String toString() {
        return name + " (kostar " + cost + "p, " +
                (unlocked ? "UPPLÅST" : "låst") + ")";
    }
}
