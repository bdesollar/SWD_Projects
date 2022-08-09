import java.util.HashMap;

/**
 * Football game class that inherits from the Game class
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Football extends Game {

    /**
     * constructor that sets the teams to be played
     * @param home Team object that is specified as the home team
     * @param away Team object that is specified as the away team
     */
    Football(Team home, Team away)
    {
        super(home, away);
        super.setLengthOfPeriod(15);
        super.setCurrentPeriod(1);
        super.setNameOfPeriod("Quarter");
    }

    /**
     * Gets the scoring methods for Football
     * @return A hashmap with all the methods for scoring and the points each method is worth
     */
    @Override
    public HashMap<String, Integer> getScoringMethods() {
        HashMap<String, Integer> scoreTypes = new HashMap<String, Integer>();
        scoreTypes.put("Touchdown", 7);
        scoreTypes.put("Field Goal", 3);
        scoreTypes.put("Extra Point", 1);
        scoreTypes.put("Two Point Conversion", 2);
        scoreTypes.put("Safety", 2);
        return scoreTypes;
    }
}
