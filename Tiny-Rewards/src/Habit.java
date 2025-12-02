public class Habit {
    private String name;
    private int pointsPerCompletion; // t.ex. 10 poäng per gång
    private int completions;         // total antal gånger gjord

    public Habit(String name, int pointsPerCompletion) {
        this.name = name;
        this.pointsPerCompletion = pointsPerCompletion;
        this.completions = 0;
    }

    public String getName() {
        return name;
    }

    public int getPointsPerCompletion() {
        return pointsPerCompletion;
    }

    public int getCompletions() {
        return completions;
    }

    public void complete() {
        completions++;
    }

    @Override
    public String toString() {
        return name + " (+" + pointsPerCompletion + "p, gjort " + completions + " ggr)";
    }
}

