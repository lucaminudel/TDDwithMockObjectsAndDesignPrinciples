using NUnit.Framework;

namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    [TestFixture]
    public class TicketDispenserTest
    {
        [Test]
        public void GIVEN_dispense_a_ticket_WHEN_dispense_a_new_ticket_THEN_turn_number_of_the_new_ticket_is_greater()
        {
            TicketDispenser tickDispenser = new TicketDispenser();
            TurnTicket oldTicket = tickDispenser.GetTurnTicket();
            TurnTicket newTicket = tickDispenser.GetTurnTicket();
            Assert.Greater(newTicket.TurnNumber, oldTicket.TurnNumber);
        }
    }
}
