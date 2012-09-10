package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Characterization test class for testing existing behaviour of 
 * {@link TicketDispenser} before refactoring.
 *
 */
public class TurnTicketDispenserCharacterizationTests {
	
	@Test
	public void returnsAnIncrementingSequenceOfTicketsUsingDefaultSequenceImplementation() {
		TicketDispenser dispenser = new TicketDispenser();
		assertEquals(0,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(1,dispenser.getTurnTicket().getTurnNumber());
		assertEquals(2,dispenser.getTurnTicket().getTurnNumber());
	}
}
