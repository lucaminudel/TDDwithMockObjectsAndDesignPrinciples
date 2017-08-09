package tddmicroexercises.turnticketdispenser.somedependencies;

import tddmicroexercises.turnticketdispenser.TurnTicket;

public class TurnTicketClient
{
    // A class with the only goal of simulating a dependency on TurnTicket
    // that has impact on the refactoring.

    public TurnTicketClient()
    {
        TurnTicket turnTicket1 = new TurnTicket(1);
        TurnTicket turnTicket2 = new TurnTicket(2);
        TurnTicket turnTicket3 = new TurnTicket(3);

        int num1 = turnTicket1.getTurnNumber();
        int num2 = turnTicket2.getTurnNumber();
        int num3 = turnTicket3.getTurnNumber();
    }
}
