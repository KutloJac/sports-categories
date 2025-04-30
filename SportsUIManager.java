import java.util.ArrayList;
import java.util.Scanner;

public class SportsUIManager {
    private Scanner scanner;
    private SportsDataManager dataManager;
    
    public SportsUIManager(SportsDataManager dataManager) {
        this.scanner = new Scanner(System.in);
        this.dataManager = dataManager;
    }
    
    public void displayMenu() {
        int choice = 0;
        
        do {
            System.out.println("\n===== SPORTS MANAGEMENT SYSTEM =====");
            System.out.println("1. Display all sports");
            System.out.println("2. Add a new sport");
            System.out.println("3. Sort sports by player count");
            System.out.println("4. Sort sports by name");
            System.out.println("5. Search for a sport by player count");
            System.out.println("6. Search for a sport by name");
            System.out.println("7. Search for a non-ball sport by equipment");
            System.out.println("8. Display sports by category");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch(choice) {
                    case 1:
                        displayAllSports();
                        break;
                    case 2:
                        addNewSport();
                        break;
                    case 3:
                        sortByPlayerCount();
                        break;
                    case 4:
                        sortByName();
                        break;

                    case 5:
                        searchByPlayerCount();
                        break;
                    case 6:
                        searchByName();
                        break;
                    case 7:
                        searchByEquipment();
                        break;
                    case 8:
                        displayByCategory();
                        break;
                    case 0:
                        System.out.println("Thank you for using the Sports Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = -1;
            }
            
        } while (choice != 0);
    }
    
    private void displayAllSports() {
        System.out.println("\n===== ALL SPORTS =====");
        
        if (dataManager.isEmpty()) {
            System.out.println("No sports available.");
            return;
        }
        
        ArrayList<Sports> sports = dataManager.getAllSports();
        for (int i = 0; i < sports.size(); i++) {
            Sports sport = sports.get(i);
            System.out.println("\n" + (i+1) + ". " + sport.getName());
            System.out.println("   Category: " + sport.getCategory());
            System.out.println("   Players: " + sport.getPlayerCount());
            System.out.println("   Popular in Botswana: " + (sport.isPopularInBotswana() ? "Yes" : "No"));
        }
    }
    
    private void addNewSport() {
        System.out.println("\n===== ADD NEW SPORT =====");
        System.out.println("1. Add Ball Sport");
        System.out.println("2. Add Non-Ball Sport");
        System.out.print("Enter choice: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice.");
                return;
            }
            
            System.out.print("Enter sport name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter player count: ");
            int playerCount = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Is it popular in Botswana? (y/n): ");
            boolean isPopular = scanner.nextLine().toLowerCase().startsWith("y");
            
            if (choice == 1) {
                System.out.print("Enter ball type: ");
                String ballType = scanner.nextLine();
                
                System.out.print("Is it a team sport? (y/n): ");
                boolean isTeamSport = scanner.nextLine().toLowerCase().startsWith("y");
                
                dataManager.addSport(new BallSports(name, playerCount, isPopular, ballType, isTeamSport));
                System.out.println("Ball sport added successfully!");
            } else {
                System.out.print("Enter equipment: ");
                String equipment = scanner.nextLine();
                
                System.out.print("Enter venue type: ");
                String venueType = scanner.nextLine();
                
                dataManager.addSport(new NonBallSports(name, playerCount, isPopular, equipment, venueType));
                System.out.println("Non-ball sport added successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (InvalidPlayerCountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void sortByPlayerCount() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to sort.");
            return;
        }
        
        dataManager.sortByPlayerCount();
        System.out.println("Sports sorted by player count!");
        
        System.out.println("\n===== SPORTS BY PLAYER COUNT =====");
        ArrayList<Sports> sports = dataManager.getAllSports();
        for (Sports sport : sports) {
            System.out.println(sport.getName() + " (" + sport.getPlayerCount() + " players)");
        }
    }
    
    private void sortByName() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to sort.");
            return;
        }
        
        dataManager.sortByName();
        System.out.println("Sports sorted by name!");
        
        System.out.println("\n===== SPORTS BY NAME =====");
        ArrayList<Sports> sports = dataManager.getAllSports();
        for (Sports sport : sports) {
            System.out.println(sport.getName());
        }
    }
    
    private void sortByPopularity() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to sort.");
            return;
        }
        
    
        System.out.println("Sports sorted by popularity in Botswana!");
        
        System.out.println("\n===== SPORTS BY POPULARITY =====");
        ArrayList<Sports> sports = dataManager.getAllSports();
        for (Sports sport : sports) {
            System.out.println(sport.getName() + " (Popular in Botswana: " + 
                             (sport.isPopularInBotswana() ? "Yes" : "No") + ")");
        }
    }
    
    private void searchByPlayerCount() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to search.");
            return;
        }
        
        System.out.print("Enter player count to search for: ");
        try {
            int playerCount = Integer.parseInt(scanner.nextLine());
            
            try {
                int index = dataManager.searchByPlayerCount(playerCount);
                System.out.println("\nFound sport with " + playerCount + " players:");
                dataManager.getSportAt(index).displayInfo();
                
                // Check for more sports with the same player count
                ArrayList<Sports> matchingSports = dataManager.getSportsByPlayerCount(playerCount);
                System.out.println("\nAll sports with " + playerCount + " players:");
                for (Sports sport : matchingSports) {
                    System.out.println("- " + sport.getName());
                }
            } catch (UnsortedListException | SportNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
    
    private void searchByName() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to search.");
            return;
        }
        
        System.out.print("Enter sport name to search for: ");
        String name = scanner.nextLine();
        
        int index = dataManager.searchByName(name);
        
        if (index != -1) {
            System.out.println("\nFound sport:");
            dataManager.getSportAt(index).displayInfo();
        } else {
            System.out.println("Sport not found: " + name);
        }
    }
    
    private void searchByEquipment() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports to search.");
            return;
        }
        
        System.out.print("Enter equipment to search for: ");
        String equipment = scanner.nextLine();
        
        int index = dataManager.searchByEquipment(equipment);
        
        if (index != -1) {
            System.out.println("\nFound non-ball sport with equipment '" + equipment + "':");
            dataManager.getSportAt(index).displayInfo();
        } else {
            System.out.println("No non-ball sport found with equipment: " + equipment);
        }
    }
    
    private void displayByCategory() {
        if (dataManager.isEmpty()) {
            System.out.println("No sports available.");
            return;
        }
        
        System.out.println("\n===== BALL SPORTS =====");
        ArrayList<Sports> ballSports = dataManager.getBallSports();
        if (ballSports.isEmpty()) {
            System.out.println("No ball sports available.");
        } else {
            for (Sports sport : ballSports) {
                System.out.println("- " + sport.getName());
            }
        }
        
        System.out.println("\n===== NON-BALL SPORTS =====");
        ArrayList<Sports> nonBallSports = dataManager.getNonBallSports();
        if (nonBallSports.isEmpty()) {
            System.out.println("No non-ball sports available.");
        } else {
            for (Sports sport : nonBallSports) {
                System.out.println("- " + sport.getName());
            }
        }
    }
}