import java.util.ArrayList;

public class FinalSportsApp {
    public static void main(String[] args) {
        ArrayList<Sportss> sports = new ArrayList<>();

        try {
            // Valid sports - fixed player counts to be greater than 0
            sports.add(new BallsSports("FootBall", 11, true, "leather", true));
            sports.add(new BallsSports("Cricket", 2, false, "plastic", false));
            sports.add(new BallsSports("Netball", 7, true, "rubber", true));
            sports.add(new BallsSports("Table-Tennis", 2, false, "plastic", false));
            sports.add(new BallsSports("Badminton", 2, false, "Feather and plastic", false));

            sports.add(new NonBallSports("100m Sprint", 1, true, "spikes", "track field"));
            sports.add(new NonBallSports("Morabaraba", 2, true, "board", "anywhere"));
            sports.add(new NonBallSports("Javelin", 1, false, "javelin", "track field"));
            sports.add(new NonBallSports("Fencing", 2, false, "picket-sword", "arena"));
            sports.add(new NonBallSports("Diketo", 1, true, "stones", "anywhere"));

            // Test invalid sport (triggers exception) - this should be in a separate try/catch
            try {
                Sportss invalid = new BallsSports("Test", -5, false, "rubber", false);
                // This line won't execute if the exception is thrown
                sports.add(invalid);
            } catch (InvalidPlayerCountException e) {
                System.out.println("Invalid sport test: " + e.getMessage());
            }

            // Sort and display
            try {
                SportsSorter.selectionSortByPlayers(sports);
                System.out.println("\nSorted by players: ");
                for(Sportss s : sports) {
                    System.out.println("- " + s.getName() + " (" + s.getPlayerCount() + ")");
                }

                // Search for a sport with 2 players
                int index = SportsSorter.binarySearchByPlayers(sports, 2);
                System.out.println("\nFound sport with 2 players at index: " + index);
                System.out.println("Sport found: " + sports.get(index).getName());
                
                // Test other sorting and searching methods
                SportsSorter.insertionSortByName(sports);
                System.out.println("\nSorted by name: ");
                for(Sportss s : sports) {
                    System.out.println("- " + s.getName());
                }
                
                // Demonstrate polymorphism
                System.out.println("\nDisplaying rules (polymorphism):");
                for(int i = 0; i < 2; i++) {
                    System.out.print(sports.get(i).getName() + " ");
                    sports.get(i).displayRules();
                }
            } catch (UnsortedListException | SportNotFoundException e) {
                System.out.println("SEARCH ERROR: " + e.getMessage());
            }
            
        } catch (InvalidPlayerCountException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
