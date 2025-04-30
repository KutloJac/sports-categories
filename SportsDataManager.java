import java.util.ArrayList;

public class SportsDataManager {
    private ArrayList<Sports> sports;
    
    public SportsDataManager() {
        this.sports = new ArrayList<>();
    }
    
    public void initializeDefaultSports() {
        try {
            // Ball sports
            addSport(new BallSports("Football", 11, true, "leather", true));
            addSport(new BallSports("Cricket", 11, false, "leather", true));
            addSport(new BallSports("Netball", 7, true, "rubber", true));
            addSport(new BallSports("Table Tennis", 2, false, "plastic", false));
            addSport(new BallSports("Badminton", 2, false, "shuttlecock", false));
            
            // Non-ball sports
            addSport(new NonBallSports("100m Sprint", 1, true, "spikes", "track field"));
            addSport(new NonBallSports("Morabaraba", 2, true, "board", "anywhere"));
            addSport(new NonBallSports("Javelin", 1, false, "javelin", "track field"));
            addSport(new NonBallSports("Fencing", 2, false, "foil", "arena"));
            addSport(new NonBallSports("Diketo", 1, true, "stones", "anywhere"));
        } catch (InvalidPlayerCountException e) {
            System.out.println("Error initializing sports: " + e.getMessage());
        }
    }
    
    public void addSport(Sports sport) {
        sports.add(sport);
    }
    
    public ArrayList<Sports> getAllSports() {
        return sports;
    }
    
    public boolean isEmpty() {
        return sports.isEmpty();
    }
    
    public int getSize() {
        return sports.size();
    }
    
    public Sports getSportAt(int index) {
        if (index >= 0 && index < sports.size()) {
            return sports.get(index);
        }
        return null;
    }
    
    public void sortByPlayerCount() {
        SportsSorter.selectionSortByPlayers(sports);
    }
    
    public void sortByName() {
        SportsSorter.insertionSortByName(sports);
    }
    
    public int searchByPlayerCount(int playerCount) throws UnsortedListException, SportNotFoundException {
        sortByPlayerCount(); // Sort first for binary search
        return SportsSorter.binarySearchByPlayers(sports, playerCount);
    }
    
    public int searchByName(String name) {
        return SportsSorter.linearSearchByName(sports, name);
    }
    
    public int searchByEquipment(String equipment) {
        return SportsSorter.linearSearchByEquipment(sports, equipment);
    }
  
    public ArrayList<Sports> getSportsByCategory(String category) {
        ArrayList<Sports> result = new ArrayList<>();
        
        for (Sports sport : sports) {
            if (sport.getCategory().equalsIgnoreCase(category)) {
                result.add(sport);
            }
        }
        
        return result;
    }
    
    public ArrayList<Sports> getBallSports() {
        ArrayList<Sports> result = new ArrayList<>();
        
        for (Sports sport : sports) {
            if (sport instanceof BallSports) {
                result.add(sport);
            }
        }
        
        return result;
    }
    
    public ArrayList<Sports> getNonBallSports() {
        ArrayList<Sports> result = new ArrayList<>();
        
        for (Sports sport : sports) {
            if (sport instanceof NonBallSports) {
                result.add(sport);
            }
        }
        
        return result;
    }
    
    public ArrayList<Sports> getSportsByPlayerCount(int playerCount) {
        ArrayList<Sports> result = new ArrayList<>();
        
        for (Sports sport : sports) {
            if (sport.getPlayerCount() == playerCount) {
                result.add(sport);
            }
        }
        
        return result;
    }
}
