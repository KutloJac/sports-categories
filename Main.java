public class Main{
    public static void main(String[] args){

                // Creating an instance of BallSports
                BallSports football = new BallSports("Football", 11, true, "round", true);
        
                // Creating an instance of NonBallSports
                NonBallSports cricket = new NonBallSports("Cricket", 6, true, "Helmet", "Stadium");
                
                // Using Polymorphism: Same method call, but behavior depends on the type of object
                System.out.println(football); // Display BallSports info
                football.displayRules(); 
                
                System.out.println(cricket); // Display NonBallSports info
                cricket.displayRules();
    }
}