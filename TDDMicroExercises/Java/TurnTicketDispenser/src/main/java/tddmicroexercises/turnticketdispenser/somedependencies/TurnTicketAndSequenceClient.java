package tddmicroexercises.turnticketdispenser.somedependencies;

import tddmicroexercises.turnticketdispenser.TurnNumberSequence;
import tddmicroexercises.turnticketdispenser.TurnTicket;

public class TurnTicketAndSequenceClient
{
    // A class with the only goal of simulating a dependencies on
    // TurnNumberSequence and TurnTicket that have impact on the refactoring.

    public TurnTicketAndSequenceClient()
    {
        TurnTicket turnTicket1 = new TurnTicket(TurnNumberSequence.getNextTurnNumber());
        TurnTicket turnTicket2 = new TurnTicket(TurnNumberSequence.getNextTurnNumber());
        TurnTicket turnTicket3 = new TurnTicket(TurnNumberSequence.getNextTurnNumber());
    }
}
