public abstract class Sports implements SportsInterface {
    private String name;
    private int playerCount;
    private boolean isPopularInBotswana;

    public Sports(String name, int playerCount, boolean isPopularInBotswana) throws InvalidPlayerCountException {
        if(playerCount <= 0) throw new InvalidPlayerCountException("Invalid players for "+ name);
        this.name = name;
        this.playerCount = playerCount;
        this.isPopularInBotswana = isPopularInBotswana;
    } 
    
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
    
    public boolean isPopularInBotswana() {
        return isPopularInBotswana;
    }
    
    public void setPopularInBotswana(boolean isPopularInBotswana) {
        this.isPopularInBotswana = isPopularInBotswana;
    }

    public abstract void displayRules();
    
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Player Count: " + playerCount);
        System.out.println("Popular in Botswana: " + (isPopularInBotswana ? "Yes" : "No"));
        displayRules();
    }
}
