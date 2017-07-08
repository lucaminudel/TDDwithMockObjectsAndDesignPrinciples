using System;
namespace TDDMicroExercises.TurnTicketDispenser.SomeDependencies
{
    public class TurnTicketAndSequenceClient
    {
		// A class with the only goal of simulating a dependencies on 
		// TurnNumberSequence and TurnTicket that have impact on the refactoring.

		public TurnTicketAndSequenceClient()
        {
			var turnTicket1 = new TurnTicket(TurnNumberSequence.GetNextTurnNumber());
			var turnTicket2 = new TurnTicket(TurnNumberSequence.GetNextTurnNumber());
			var turnTicket3 = new TurnTicket(TurnNumberSequence.GetNextTurnNumber());
        }
    }
}
