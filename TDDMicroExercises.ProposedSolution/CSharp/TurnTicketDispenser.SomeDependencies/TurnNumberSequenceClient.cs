using System;
namespace TDDMicroExercises.OneSolution.TurnTicketDispenser.SomeDependencies
{
    public class TurnNumberSequenceClient
    {
		// A class with the only goal of simulating a dependency on TurnNumberSequence
		// that has impact on the refactoring.

		public TurnNumberSequenceClient()
        {
            int nextUniqueTicketNumber;
            var globalSequence = TurnNumberSequence.GlobalTurnNumberSequence;
            nextUniqueTicketNumber = globalSequence.GetNextTurnNumber();
            nextUniqueTicketNumber = globalSequence.GetNextTurnNumber();
			nextUniqueTicketNumber = globalSequence.GetNextTurnNumber();
		}
    }
}
