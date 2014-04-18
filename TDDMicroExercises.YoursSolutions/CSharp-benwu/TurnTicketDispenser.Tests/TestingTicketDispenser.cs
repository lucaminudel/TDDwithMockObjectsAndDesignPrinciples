using Moq;

namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    public class TestingTicketDispenser : TicketDispenser
    {
        public override TurnTicket GetTurnTicket()
        {
            var turnNumberSequence = new Mock<TurnNumberSequence>();
            turnNumberSequence
                .Setup(t => t.GetNextTurnNumber())
                .Returns(11);

            int newTurnNumber = turnNumberSequence.Object.GetNextTurnNumber();
            var newTurnTicket = new TurnTicket(newTurnNumber);

            turnNumberSequence.Verify(t => t.GetNextTurnNumber());
            return newTurnTicket;
        }
    }
}