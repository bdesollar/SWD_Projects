import java.util.HashMap;

/**
 * Basketball game class that inherits from the Game class
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Basketball extends Game {

    /**
     * constructor that sets the teams to be played
     * @param home Team object that is specified as the home team
     * @param away Team object that is specified as the away team
     */
    public Basketball(Team home, Team away)
    {
        super(home, away);
        super.setLengthOfPeriod(15);
        super.setCurrentPeriod(1);
        super.setNameOfPeriod("Period");
        super.setGameStarted(true);
    }

    /**
     * Gets the scoring methods for Basketball
     * @return A hashmap with all the methods for scoring and the points each method is worth
     */
    @Override
    public HashMap<String, Integer> getScoringMethods() {
        HashMap<String, Integer> scoreTypes = new HashMap<String, Integer>();
        scoreTypes.put("3 Pointer", 3);
        scoreTypes.put("2 Pointer", 2);
        scoreTypes.put("Free Throw", 1);
        return scoreTypes;
    }
}
