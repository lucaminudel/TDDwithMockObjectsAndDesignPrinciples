using System;
namespace TDDMicroExercises.OneSolution.TurnTicketDispenser.SomeDependencies
{
    public class TurnTicketAndSequenceClient
    {
		// A class with the only goal of simulating dependencies on 
		// TurnTicket and TurnNumberSequence that have impact on the refactoring.

		public TurnTicketAndSequenceClient()
        {
			var globalSequence = TurnNumberSequence.GlobalTurnNumberSequence;
			var turnTicket1 = new TurnTicket(globalSequence.GetNextTurnNumber());
			var turnTicket2 = new TurnTicket(globalSequence.GetNextTurnNumber());
			var turnTicket3 = new TurnTicket(globalSequence.GetNextTurnNumber());
        }
    }
}
