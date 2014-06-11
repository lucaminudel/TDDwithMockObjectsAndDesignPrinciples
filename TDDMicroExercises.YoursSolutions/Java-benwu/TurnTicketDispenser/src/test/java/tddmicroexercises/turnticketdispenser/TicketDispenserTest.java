package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicketDispenserTest {
    @Test
    public void a_new_ticket_should_have_the_turn_number_subsequent_to_the_previous_ticket() {
        // Arrange
        TicketDispenser ticketDispenser = new TicketDispenser();

        // Act
        TurnTicket previousTicket = ticketDispenser.getTurnTicket();
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        // Assert
        assertTrue(newTicket.getTurnNumber() > previousTicket.getTurnNumber());
    }

    // TODO-acceptance-test: a new ticket should have the turn number subsequent to the previous ticket from another dispenser
    // TODO-acceptance-test: after ticket 10 come ticket 11

}