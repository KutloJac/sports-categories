import java.util.ArrayList;
public class Main2{
public static void main(String[] args) {
    ArrayList<Sports> sportsList = new ArrayList<>();

     sportsList.add(new BallSports("Soccer", 11));
        sportsList.add(new BallSports("Basketball", 5));

    try {
        int targetPlayers = 5; // Example target
        int index = binarySearchByPlayers(sportsList, targetPlayers);
        System.out.println("Sport found at index: " + index);
    } catch (UnsortedListException | SportNotFoundException e) {
        System.err.println(e.getMessage());
    }
}}
