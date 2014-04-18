using NUnit.Framework;

namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    [TestFixture]
    public class TicketDispenserTest
    {
        [Test]
        public void GIVEN_dispense_a_ticket_WHEN_dispense_a_new_ticket_at_the_same_machine_THEN_turn_number_of_the_new_ticket_is_greater()
        {
            TicketDispenser ticketDispenser = new TicketDispenser();
            TurnTicket oldTicket = ticketDispenser.GetTurnTicket();
            TurnTicket newTicket = ticketDispenser.GetTurnTicket();
            Assert.Greater(newTicket.TurnNumber, oldTicket.TurnNumber);
        }

        [Test]
        public void GIVEN_dispense_a_ticket_WHEN_dispense_a_new_ticket_at_another_machine_THEN_turn_number_of_the_new_ticket_is_greater()
        {
            TicketDispenser ticketDispenser = new TicketDispenser();
            TurnTicket oldTicket = ticketDispenser.GetTurnTicket();

            TicketDispenser anotherTicketDispenser = new TicketDispenser();
            TurnTicket newTicket = anotherTicketDispenser.GetTurnTicket();

            Assert.Greater(newTicket.TurnNumber, oldTicket.TurnNumber);
        }

    }
}
