namespace TDDMicroExercises.TurnTicketDispenser.SomeDependencies
{
    public class TurnTicketClient
    {
		// A class with the only goal of simulating a dependency on TurnTicket
		// that has impact on the refactoring.

		public TurnTicketClient()
        {
            var turnTicket1 = new TurnTicket(1);
			var turnTicket2 = new TurnTicket(2);
			var turnTicket3 = new TurnTicket(3);

			var num1 = turnTicket1.TurnNumber;
			var num2 = turnTicket2.TurnNumber;
			var num3 = turnTicket3.TurnNumber;
		}
    }
}
