package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    private TurnNumberSequence turnNumberSequence;

    public TicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TicketDispenser() {
        this.turnNumberSequence = new TurnNumberSequence();
    }

    public TurnTicket getTurnTicket()
    {
        // TODO: Depending on a static method violates the Dependency Inversion Principle and Open-Closed Principle.
        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
