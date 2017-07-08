using System;
namespace TDDMicroExercises.TurnTicketDispenser.SomeDependencies
{
    public class TurnNumberSequenceClient
    {
		// A class with the only goal of simulating a dependency on TurnNumberSequence
		// that has impact on the refactoring.

		public TurnNumberSequenceClient()
        {
            int nextUniqueTicketNumber;
            nextUniqueTicketNumber = TurnNumberSequence.GetNextTurnNumber();
			nextUniqueTicketNumber = TurnNumberSequence.GetNextTurnNumber();
			nextUniqueTicketNumber = TurnNumberSequence.GetNextTurnNumber();
		}
    }
}
