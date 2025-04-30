public class BallSports extends Sports {
    private String ballType;
    private boolean isTeamSport;

    public BallSports(String name, int playerCount, boolean isPopularInBotswana, String ballType, boolean isTeamSport) throws InvalidPlayerCountException {
        super(name, playerCount, isPopularInBotswana);
        this.ballType = ballType;
        this.isTeamSport = isTeamSport;
    }
    
    public String getBallType() {
        return ballType;
    }
    
    public void setBallType(String ballType) {
        this.ballType = ballType;
    }
    
    public boolean isTeamSport() {
        return isTeamSport;
    }
    
    public void setTeamSport(boolean isTeamSport) {
        this.isTeamSport = isTeamSport;
    }
    
    // Polymorphism: Override rules
    @Override
    public void displayRules() {
        System.out.println("Rule: " + ballType + " ball. Team sport? " + (isTeamSport ? "Yes" : "No"));
    }
    
    // Implementation of interface method
    @Override
    public String getCategory() {
        return "Ball Sport";
    }
}
