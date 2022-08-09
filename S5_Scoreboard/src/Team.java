/**
 * Team class where the team info is stored
 * @version 1.0, 30 November 2021
 * @author Ben DeSollar
 */

public class Team{

    /**
     * name of the team
     */
    private String teamName;
    /**
     * score of the teams
     */
    private int score = 0;

    /**
     * constructor that initializes a teams name
     * @param team name of the team
     */
    public Team(String team)
    {
        setTeam(team);
    }

    /**
     * Gets the teams score
     * @return the teams score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the teams score
     * @param score the score to set the current score to
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * sets the team name
     * @param teamName the name of the team to be set
     */
    void setTeam(String teamName)
    {
        this.teamName = teamName;
    }

    /**
     * gets the team name
     * @return the name of the team
     */
    String getTeamName()
    {
        return this.teamName;
    }
}
