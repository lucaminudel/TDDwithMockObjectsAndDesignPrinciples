package tddmicroexercises.turnticketdispenser.somedependencies;

import tddmicroexercises.turnticketdispenser.TicketDispenser;

public class TicketDispenserClient
{
	// A class with the only goal of simulating a dependency on TicketDispenser
	// that has impact on the refactoring.

	public TicketDispenserClient()
	{
		new TicketDispenser().getTurnTicket();
		new TicketDispenser().getTurnTicket();
		new TicketDispenser().getTurnTicket();
	}
}
