import java.util.ArrayList;

public class SportsSorter {
    public static void selectionSortByPlayers(ArrayList<Sports> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;

            for(int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getPlayerCount() < list.get(minIndex).getPlayerCount()) {
                    minIndex = j;
                }
            }

            Sports temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static int binarySearchByPlayers(ArrayList<Sports> list, int targetPlayers) throws UnsortedListException, SportNotFoundException {
        if(!isSortedByPlayers(list)) throw new UnsortedListException("List must be sorted for binary search!");

        int left = 0;
        int right = list.size() - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int currentPlayers = list.get(mid).getPlayerCount();
            
            if(currentPlayers == targetPlayers) {
                return mid;
            } else if(currentPlayers < targetPlayers) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        throw new SportNotFoundException("No sport with " + targetPlayers + " players");
    }

    public static boolean isSortedByPlayers(ArrayList<Sports> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).getPlayerCount() > list.get(i+1).getPlayerCount())
                return false;
        }
        return true;
    }

    public static int linearSearchByEquipment(ArrayList<Sports> list, String equipment) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof NonBallSports) {
                NonBallSports sport = (NonBallSports) list.get(i);
                if (sport.getEquipment().equalsIgnoreCase(equipment)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void insertionSortByName(ArrayList<Sports> list) {
        for (int i = 1; i < list.size(); i++) {
            Sports key = list.get(i);
            int j = i - 1;
            
            while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            
            list.set(j + 1, key);
        }
    }
    
    
    public static int linearSearchByName(ArrayList<Sports> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
        }
    }
