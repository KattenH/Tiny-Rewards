import java.util.Scanner;

public class HabitRewardsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserState userState = new UserState();

        // Några standardvanor och belöningar
        userState.addHabit(new Habit("Träna", 10));
        userState.addHabit(new Habit("Ingen läsk idag", 5));

        userState.addReward(new Reward("Köpa sushi", 50));
        userState.addReward(new Reward("Spela tv-spel 2h", 40));

        boolean running = true;

        while (running) {
            System.out.println("\n=== Habit Rewards ===");
            System.out.println("Poäng: " + userState.getTotalPoints());
            System.out.println("1. Visa vanor");
            System.out.println("2. Markera vana som klar idag");
            System.out.println("3. Visa belöningar");
            System.out.println("4. Lås upp belöning");
            System.out.println("0. Avsluta");
            System.out.print("Val: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Dina vanor:");
                    userState.getHabits().forEach(System.out::println);
                    break;

                case "2":
                    System.out.println("Vilken vana har du gjort?");
                    userState.getHabits().forEach(h -> System.out.println("- " + h.getName()));
                    System.out.print("Skriv namn: ");
                    String habitName = scanner.nextLine();
                    if (userState.completeHabit(habitName)) {
                        System.out.println("Bra jobbat! Vana markerad som klar.");
                    } else {
                        System.out.println("Hittade ingen vana med det namnet.");
                    }
                    break;

                case "3":
                    System.out.println("Belöningar:");
                    userState.getRewards().forEach(System.out::println);
                    break;

                case "4":
                    System.out.println("Vilken belöning vill du låsa upp?");
                    userState.getRewards().forEach(r -> System.out.println("- " + r.getName()));
                    System.out.print("Skriv namn: ");
                    String rewardName = scanner.nextLine();
                    if (userState.unlockReward(rewardName)) {
                        System.out.println("Belöning upplåst! Du får nu ”" + rewardName + "”.");
                    } else {
                        System.out.println("Gick inte att låsa upp. Kanske för få poäng eller redan upplåst.");
                    }
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Ogiltigt val.");
            }
        }

        System.out.println("Hejdå!");
        scanner.close();
    }
}
