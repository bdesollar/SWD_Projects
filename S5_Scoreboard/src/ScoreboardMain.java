import java.util.Scanner;

/**
 * Main class to the games and create the user interface
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class ScoreboardMain {

    /**
     * Creates a game and the user interface for the user to play
     * @param args  an array of strings that can be passed in when starting the main program
     */
    public static void main(String[] args)
    {
        System.out.println("Please select the type of Game to play\n" +
                "1. Football\n2. Soccer\n3. Hockey\n4. Basketball\nEnter Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String teamName1, teamName2;
        System.out.print("Enter Home Team: ");
        sc.nextLine();
        teamName1 = sc.nextLine();
        Team homeTeam = new Team(teamName1);
        System.out.print("Enter Away Team: ");
        teamName2 = sc.nextLine();
        Team awayTeam = new Team(teamName2);
        System.out.println("\n");
        int userOptionChoice;
        if(choice == 1) {
            // Creates a game of type Football
            Game userGame = new Football(homeTeam, awayTeam);
            while(!userGame.isGameOver())
            {
                System.out.println(userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                System.out.println("Current " + userGame.getNameOfPeriod() + ": " + userGame.getCurrentPeriod());
                System.out.println("Menu:\n" + "1. " + userGame.getHome().getTeamName() + " Touchdown");
                System.out.println("2. " + userGame.getHome().getTeamName() + " Field Goal");
                System.out.println("3. " + userGame.getHome().getTeamName() + " Extra Point");
                System.out.println("4. " + userGame.getHome().getTeamName() + " Two Point Conversion");
                System.out.println("5. " + userGame.getHome().getTeamName() + " Safety");
                System.out.println("6. " + userGame.getAway().getTeamName() + " Touchdown");
                System.out.println("7. " + userGame.getAway().getTeamName() + " Field Goal");
                System.out.println("8. " + userGame.getAway().getTeamName() + " Extra Point");
                System.out.println("9. " + userGame.getAway().getTeamName() + " Two Point Conversion");
                System.out.println("10. " + userGame.getAway().getTeamName() + " Safety");
                System.out.println("11. End Quarter");
                System.out.println("Enter Choice: ");
                userOptionChoice = sc.nextInt();
                if(userOptionChoice == 1) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Touchdown"));
                }
                else if(userOptionChoice == 2) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Field Goal"));
                }
                else if(userOptionChoice == 3) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Extra Point"));
                }
                else if(userOptionChoice == 4) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Two Point Conversion"));
                }
                else if(userOptionChoice == 5) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Safety"));
                }
                else if(userOptionChoice == 6) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Touchdown"));
                }
                else if(userOptionChoice == 7) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Field Goal"));
                }
                else if(userOptionChoice == 8) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Extra Point"));
                }
                else if(userOptionChoice == 9) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Two Point Conversion"));
                }
                else if(userOptionChoice == 10) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Safety"));
                }
                else if(userOptionChoice == 11)
                {
                    // checks if there is another period in the game, if not end the game
                    if((userGame.getCurrentPeriod() + 1) > 4)
                    {
                        userGame.setGameOver(true);
                        System.out.println("Game is Over");
                    }
                    else
                    {
                        userGame.endCurrentPeriod();
                    }
                }
                // checks if the game is over
                if(userGame.isGameOver())
                {
                    System.out.println("Current " + userGame.getNameOfPeriod() + ": Final");
                    if(userGame.getHome().getScore() > userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getHome().getTeamName());
                    }
                    else if(userGame.getHome().getScore() < userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getAway().getTeamName());
                    }
                    else if(userGame.getHome().getScore() == userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam("Tie Game");
                    }
                    System.out.println("Final Score: " + userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                    System.out.println("Winner: " + userGame.getWinningTeam());
                }
            }
        }
        else if(choice == 2)
        {
            Game userGame = new Soccer(homeTeam, awayTeam);
            while(!userGame.isGameOver())
            {
                System.out.println(userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                System.out.println("Current " + userGame.getNameOfPeriod() + ": " + userGame.getCurrentPeriod());
                System.out.println("Menu:\n" + "1. " + userGame.getHome().getTeamName() + " Goal");
                System.out.println("2. " + userGame.getAway().getTeamName() + " Goal");
                System.out.println("3. End Period");
                System.out.println("Enter Choice: ");
                userOptionChoice = sc.nextInt();
                if(userOptionChoice == 1) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Goal"));
                }
                else if(userOptionChoice == 2) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Goal"));
                }
                else if(userOptionChoice == 3)
                {
                    if((userGame.getCurrentPeriod() + 1) > 2)
                    {
                        userGame.setGameOver(true);
                        System.out.println("Game is Over");
                    }
                    else
                    {
                        userGame.endCurrentPeriod();;
                    }
                }
                if(userGame.isGameOver())
                {
                    System.out.println("Current " + userGame.getNameOfPeriod() + ": Final");
                    if(userGame.getHome().getScore() > userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getHome().getTeamName());
                    }
                    else if(userGame.getHome().getScore() < userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getAway().getTeamName());
                    }
                    else if(userGame.getHome().getScore() == userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam("Tie Game");
                    }
                    System.out.println("Final Score: " + userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                    System.out.println("Winner: " + userGame.getWinningTeam());
                }
            }
        }
        else if(choice == 3)
        {
            Game userGame = new Hockey(homeTeam, awayTeam);
            while(!userGame.isGameOver())
            {
                System.out.println(userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                System.out.println("Current " + userGame.getNameOfPeriod() + ": " + userGame.getCurrentPeriod());
                System.out.println("Menu:\n" + "1. " + userGame.getHome().getTeamName() + " Goal");
                System.out.println("2. " + userGame.getAway().getTeamName() + " Goal");
                System.out.println("3. End Period");
                System.out.println("Enter Choice: ");
                userOptionChoice = sc.nextInt();
                if(userOptionChoice == 1) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Goal"));
                }
                else if(userOptionChoice == 2) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Goal"));
                }
                else if(userOptionChoice == 3)
                {
                    if((userGame.getCurrentPeriod() + 1) > 3)
                    {
                        userGame.setGameOver(true);
                        System.out.println("Game is Over");
                    }
                    else
                    {
                        userGame.endCurrentPeriod();;
                    }
                }
                if(userGame.isGameOver())
                {
                    System.out.println("Current " + userGame.getNameOfPeriod() + ": Final");
                    if(userGame.getHome().getScore() > userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getHome().getTeamName());
                    }
                    else if(userGame.getHome().getScore() < userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getAway().getTeamName());
                    }
                    else if(userGame.getHome().getScore() == userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam("Tie Game");
                    }
                    System.out.println("Final Score: " + userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                    System.out.println("Winner: " + userGame.getWinningTeam());
                }
            }
        }
        else if(choice == 4) {
            Game userGame = new Basketball(homeTeam, awayTeam);
            while(!userGame.isGameOver())
            {
                System.out.println(userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                System.out.println("Current " + userGame.getNameOfPeriod() + ": " + userGame.getCurrentPeriod());
                System.out.println("Menu:\n" + "1. " + userGame.getHome().getTeamName() + " 3 Pointer");
                System.out.println("2. " + userGame.getHome().getTeamName() + " 2 Pointer");
                System.out.println("3. " + userGame.getHome().getTeamName() + " Free Throw");
                System.out.println("4. " + userGame.getAway().getTeamName() + " 3 Pointer");
                System.out.println("5. " + userGame.getAway().getTeamName() + " 2 Pointer");
                System.out.println("6. " + userGame.getAway().getTeamName() + " Free Throw");
                System.out.println("7. End Period");
                System.out.println("Enter Choice: ");
                userOptionChoice = sc.nextInt();
                if(userOptionChoice == 1) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("3 Pointer"));
                }
                else if(userOptionChoice == 2) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("2 Pointer"));
                }
                else if(userOptionChoice == 3) {
                    userGame.getHome().setScore(userGame.getHome().getScore() + userGame.getScoringMethods().get("Free Throw"));
                }
                else if(userOptionChoice == 4) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("3 Pointer"));
                }
                else if(userOptionChoice == 5) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("2 Pointer"));
                }
                else if(userOptionChoice == 6) {
                    userGame.getAway().setScore(userGame.getAway().getScore() + userGame.getScoringMethods().get("Free Throw"));
                }
                else if(userOptionChoice == 7)
                {
                    if((userGame.getCurrentPeriod() + 1) > 4)
                    {
                        userGame.setGameOver(true);
                        System.out.println("Game is Over");
                    }
                    else
                    {
                        userGame.endCurrentPeriod();;
                    }
                }
                if(userGame.isGameOver())
                {
                    System.out.println("Current " + userGame.getNameOfPeriod() + ": Final");
                    if(userGame.getHome().getScore() > userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getHome().getTeamName());
                    }
                    else if(userGame.getHome().getScore() < userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam(userGame.getAway().getTeamName());
                    }
                    else if(userGame.getHome().getScore() == userGame.getAway().getScore())
                    {
                        userGame.setWinningTeam("Tie Game");
                    }
                    System.out.println("Final Score: " + userGame.getHome().getTeamName() + " - " + userGame.getHome().getScore() + ", " + userGame.getAway().getTeamName() + " - " + userGame.getAway().getScore());
                    System.out.println("Winner: " + userGame.getWinningTeam());
                }
            }
        }
        else{
            System.out.println("Choice did not exist\n");
        }

    }
}
