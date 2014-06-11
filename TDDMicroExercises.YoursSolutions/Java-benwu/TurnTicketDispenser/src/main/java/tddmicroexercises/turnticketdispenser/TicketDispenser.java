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
        int newTurnNumber = this.turnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
