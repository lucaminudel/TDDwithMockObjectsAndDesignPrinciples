package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    public TurnTicket getTurnTicket()
    {
        // TODO: Depending on a static method violates the Dependency Inversion Principle and Open-Closed Principle.
        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
