import java.util.HashMap;

/**
 * Soccer game class that inherits from the Game class
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Soccer extends Game {

    /**
     * constructor that sets the teams to be played
     * @param home Team object that is specified as the home team
     * @param away Team object that is specified as the away team
     */
    Soccer(Team home, Team away)
    {
        super(home, away);
        super.setLengthOfPeriod(45);
        super.setCurrentPeriod(1);
        super.setNameOfPeriod("Period");
    }

    /**
     * Gets the scoring methods for Soccer
     * @return A hashmap with all the methods for scoring and the points each method is worth
     */
    @Override
    public HashMap<String, Integer> getScoringMethods() {
        HashMap<String, Integer> scoreTypes = new HashMap<String, Integer>();
        scoreTypes.put("Goal", 1);
        return scoreTypes;
    }
}
