package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence
{
    protected static int turnNumber = 0;

    public static int getNextTurnNumber()
    {
        return turnNumber++;
    }
}
