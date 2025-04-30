public class BallsSports extends Sportss{
        private String ballType;
        private boolean isTeamSport;
    
        public BallsSports(String name, int playerCount, boolean isPopularInBotswana, String ballType, boolean isTeamSport) throws InvalidPlayerCountException{
            super(name, playerCount, isPopularInBotswana);
            this.ballType = ballType;
            this.isTeamSport = isTeamSport;
            
        }
        
        // Polymorphism: Override rules
        @Override
        public void displayRules() {
            System.out.println("Rule: " + ballType + "ball. Team sport? " + isTeamSport);
        }
    
    
}
