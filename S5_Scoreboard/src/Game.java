import java.util.HashMap;
/**
 * Superclass that all the games inherit from
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public abstract class Game {

    /**
     * can be used whether the game has started yet or not
     */
    private boolean gameStarted;
    /**
     * used to see if the game is over or not
     */
    private boolean gameOver;
    /**
     * the current period of the game
     */
    private int currentPeriod;
    /**
     * the length of the period/quarter for the specified game
     */
    private double lengthOfPeriod;
    /**
     * name of the period of length, i.e. (Quarter or Period)
     */
    private String nameOfPeriod;
    /**
     * Team object for the home team
     */
    private Team home;
    /**
     * Team object for the away team
     */
    private Team away;
    /**
     * contains the name of the team that wins when it happens or can contain the word "Tie" if the game was tied
     */
    private String winningTeam;

    /**
     * constructor that sets the Team objects for the home and away teams
     * @param home Team object for the home team
     * @param away Team object for the away team
     */
    Game(Team home, Team away)
    {
        setHome(home);
        setAway(away);
    }

    /**
     * gets a reference to the Team object that is the home team
     * @return a reference to the Team object that is the home team
     */
    public Team getHome() {
        return home;
    }

    /**
     * sets the Team object for the home team
     * @param home Team object for the home team
     */
    public void setHome(Team home) {
        this.home = home;
    }

    /**
     * gets a reference to the Team object that is the away team
     * @return a reference to the Team object that is the away team
     */
    public Team getAway() {
        return away;
    }

    /**
     * sets the Team object for the home team
     * @param away Team object for the away team
     */
    public void setAway(Team away) {
        this.away = away;
    }

    /**
     * sets whether the game has been started or not
     * @param gameStarted true or false for the game being started or not
     */
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    /**
     * checks if the game is over or not
     * @return true or false if the game is over or not
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * sets the game to either be over or not
     * @param gameOver true or false for the game being over or not
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * gets the current period/quarter for the Game
     * @return the current period/quarter for the Game
     */
    public int getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * sets the current period/quarter for the Game
     * @param currentPeriod the current period/quarter for the Game
     */
    public void setCurrentPeriod(int currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    /**
     * ends the period and updates the current period to be the next period
     */
    public void endCurrentPeriod()
    {
        this.currentPeriod += 1;
    }

    /**
     * gets the length of the current period/quarter
     * @return the length of the current period/quarter
     */
    public double getLengthOfPeriod() {
        return lengthOfPeriod;
    }

    /**
     * sets the length of the current period/quarter
     * @param lengthOfPeriod the length of the period/quarter to be set to
     */
    public void setLengthOfPeriod(double lengthOfPeriod) {
        this.lengthOfPeriod = lengthOfPeriod;
    }

    /**
     * gets the name of the period, i.e. period or quarter
     * @return the name of the period, i.e. period or quarter
     */
    public String getNameOfPeriod() {
        return nameOfPeriod;
    }

    /**
     * sets the name of the period, i.e. period or quarter
     * @param nameOfPeriod what name of the period is, i.e. period or quarter
     */
    public void setNameOfPeriod(String nameOfPeriod) {
        this.nameOfPeriod = nameOfPeriod;
    }

    /**
     * sets the name of the winning team; if there is a tie, then this is set to "Tie"
     * @return the name of the winning team
     */
    public String getWinningTeam() {
        return winningTeam;
    }

    /**
     * sets the name of the winning team
     * @param winningTeam the name of the winning team
     */
    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    /**
     * the scoring methods that can be used in each game
     * @return a hashmap where the key is the scoring method name, and the value is the amount of points its worth
     */
    public abstract HashMap<String, Integer> getScoringMethods();
}
