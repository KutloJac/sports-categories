public class NonBallSports extends Sports {
    private String equipment;
    private String venueType;

    public NonBallSports(String name, int playerCount, boolean isPopularInBotswana, String equipment, String venueType) throws InvalidPlayerCountException {
        super(name, playerCount, isPopularInBotswana);
        this.equipment = equipment;
        this.venueType = venueType; 
    }

    public String getEquipment() {
        return equipment;
    }
    
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getVenueType() {
        return venueType;
    }
    
    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }
    
    @Override
    public void displayRules() {
        System.out.println("Rule: Use " + equipment + ". Venue: " + venueType);
    }
    
    @Override
    public String getCategory() {
        return "Non-Ball Sport";
    }
}
