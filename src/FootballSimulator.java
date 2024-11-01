import java.util.Random;
import java.util.Scanner;


//Ask the user to name the teams about to face each other 
// Use random to generate their position on the table (1 - 20), print team along with their positions 
// Import time to make it wait for 3 seconds before it continues
// Use the random to generate the scores for both teams for the first half (0 - 2)
// Make it wait for 5 seconds before moving on 
// Use the random to generate the scores again for the second half 
// use an if statement to check whether it's a tie or one team leads
// If a team leads, print that team as the winner
// if it is a tie, take it to extra time.
// print the golden rules for the game(if a team scores first, that team wins the game)
// Use random to generate a random team to score first 


public class FootballSimulator {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // This is used to prompt the user to choose his options for the teams that are gonna paly 
        System.out.print("Enter the Home Team Name: ");
        String homeTeam = scanner.nextLine();
        
        System.out.print("Enter the Away Team Name: ");
        String awayTeam = scanner.nextLine();

        // Randomly generating and displaying the positions of the teams listed 
        int homeTeamPosition = random.nextInt(20) + 1;
        int awayTeamPosition = random.nextInt(20) + 1;
        System.out.println(homeTeam + " Position: " + homeTeamPosition);
        System.out.println(awayTeam + " Position: " + awayTeamPosition);
        
        // This is used to make the program delay a few seconds before continuing
        Thread.sleep(3000);

        // Simulating the scores for the first half
        int homeScoreFirstHalf = random.nextInt(3);
        int awayScoreFirstHalf = random.nextInt(3);
        System.out.println("\nFirst Half Scores:");
        System.out.println(homeTeam + ": " + homeScoreFirstHalf);
        System.out.println(awayTeam + ": " + awayScoreFirstHalf);

        /* 
         * Delaying before moving on to the second half. This is more like the half time break the team and player take
         * before moving on with the game
         */
        Thread.sleep(5000);

        // Simulating the scores for the second half
        int homeScoreSecondHalf = random.nextInt(3);
        int awayScoreSecondHalf = random.nextInt(3);
        System.out.println("\nSecond Half Scores:");
        System.out.println(homeTeam + ": " + (homeScoreFirstHalf + homeScoreSecondHalf));
        System.out.println(awayTeam + ": " + (awayScoreFirstHalf + awayScoreSecondHalf));

        // Calculating final scores
        int finalHomeScore = homeScoreFirstHalf + homeScoreSecondHalf;
        int finalAwayScore = awayScoreFirstHalf + awayScoreSecondHalf;

        // Determining the game outcome. If there will be a need for extra time.
        if (finalHomeScore > finalAwayScore) {
            System.out.println("\nFinal Result: " + homeTeam + " wins with a score of " + finalHomeScore + " to " + finalAwayScore);
        } else if (finalAwayScore > finalHomeScore) {
            System.out.println("\nFinal Result: " + awayTeam + " wins with a score of " + finalAwayScore + " to " + finalHomeScore);
        } else {
            System.out.println("\nIt's a tie! Going into extra time...");

            // Displaying Golden Rules
            System.out.println("Golden Rule: The first team to score wins the game!");

            // Simulating extra time with golden goal rule
            int goldenGoalWinner = random.nextInt(2);  // 0 for home, 1 for away
            Thread.sleep(3000);

            if (goldenGoalWinner == 0) {
                System.out.println(homeTeam + " scores first and wins the game!");
            } else {
                System.out.println(awayTeam + " scores first and wins the game!");
            }
            
            System.out.println("Go Hatters!");
            System.out.println("Program by: Stephen Wereko");
        }
        
        scanner.close();
    }
}
