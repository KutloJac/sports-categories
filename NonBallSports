public class NonBallSports extends Sportss {
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

    public String getVenueType() {  // Fixed method name for consistency
        return venueType;
    }
    
    //Polymorphism: Override rules
    @Override
    public void displayRules() {
        System.out.println("Rule: Use " + equipment + ". Venue: " + venueType);  // Fixed message
    }
}
