using NUnit.Framework;

namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    [TestFixture]
    public class TicketDispenserTest
    {
        [Test]
        public void GIVEN_dispense_a_ticket_WHEN_check_ticket_turn_number_THEN_get_characterization()
        {
            TicketDispenser tickDispenser = new TicketDispenser();
            TurnTicket ticket = tickDispenser.GetTurnTicket();
            ticket = tickDispenser.GetTurnTicket();
            ticket = tickDispenser.GetTurnTicket();
            Assert.AreEqual(2, ticket.TurnNumber);
        }
    }
}
