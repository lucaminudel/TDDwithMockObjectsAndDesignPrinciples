using System;
namespace TDDMicroExercises.TurnTicketDispenser.SomeDependencies
{
    public class TicketDispenserClient
    {
		// A class with the only goal of simulating a dependency on TicketDispenser
		// that has impact on the refactoring.

		public TicketDispenserClient()
        {
			new TicketDispenser().GetTurnTicket();
			new TicketDispenser().GetTurnTicket();
			new TicketDispenser().GetTurnTicket();
		}
    }
}
