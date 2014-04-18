using Moq;

namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    public class TestingTicketDispenser : TicketDispenser
    {
        public override TurnTicket GetTurnTicket()
        {
            var turnNumberSequence = new Mock<TurnNumberSequence>();
            int newTurnNumber = turnNumberSequence.GetNextTurnNumber();
            var newTurnTicket = new TurnTicket(newTurnNumber);

            return newTurnTicket;
        }
    }
}