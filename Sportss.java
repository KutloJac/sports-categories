public abstract class Sportss {
    private String name;
    private int playerCount;
    private boolean isPopularInBotswana;

    public Sportss(String name, int playerCount, boolean isPopularInBotswana) throws InvalidPlayerCountException {
        if(playerCount <= 0) throw new InvalidPlayerCountException("Invalid players for "+ name);
        this.name = name;
        this.playerCount = playerCount;
        this.isPopularInBotswana = isPopularInBotswana;
    } 
    
    // Basic getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPlayerCount() {
        return playerCount;
    }
    
    public void setPlayerCount(int playerCount) throws InvalidPlayerCountException {
        if (playerCount <= 0) {
            throw new InvalidPlayerCountException("Invalid players: " + playerCount + " for " + name);
        }
        this.playerCount = playerCount;
    }
    
    public boolean getIsPopularInBotswana() {  // Fixed method name for consistency
        return isPopularInBotswana;
    }
    
    public void setIsPopularInBotswana(boolean isPopularInBotswana) {
        this.isPopularInBotswana = isPopularInBotswana;
    }

    // Abstract method for polymorphism
    public abstract void displayRules();
}
