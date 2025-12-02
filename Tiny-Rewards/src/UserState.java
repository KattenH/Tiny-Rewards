import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserState {
    private int totalPoints;
    private List<Habit> habits;
    private List<Reward> rewards;

    public UserState() {
        this.totalPoints = 0;
        this.habits = new ArrayList<>();
        this.rewards = new ArrayList<>();
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public boolean completeHabit(String habitName) {
        Optional<Habit> habitOpt = habits.stream()
                .filter(h -> h.getName().equalsIgnoreCase(habitName))
                .findFirst();

        if (habitOpt.isPresent()) {
            Habit habit = habitOpt.get();
            habit.complete();
            totalPoints += habit.getPointsPerCompletion();
            return true;
        } else {
            return false;
        }
    }

    public boolean unlockReward(String rewardName) {
        Optional<Reward> rewardOpt = rewards.stream()
                .filter(r -> r.getName().equalsIgnoreCase(rewardName))
                .findFirst();

        if (rewardOpt.isPresent()) {
            Reward reward = rewardOpt.get();
            if (!reward.isUnlocked() && totalPoints >= reward.getCost()) {
                totalPoints -= reward.getCost();
                reward.unlock();
                return true;
            }
        }
        return false;
    }
}
