package tddmicroexercises.turnticketdispenser;

import junit.framework.Assert;

import org.junit.Test;

public class TicketDispenserTest {
	
	@Test public void
	should_generate_turn_ticket_with_current_number() {
		ITurnNumberSequence seq = new MockTurnNumberSequence(0);
		TicketDispenser td = new TicketDispenser(seq);
		
		Assert.assertEquals(0, td.getTurnTicket().getTurnNumber());
		Assert.assertEquals(1, td.getTurnTicket().getTurnNumber());
	}
	
	@Test public void
	should_able_to_share_turn_number_sequence() {
		ITurnNumberSequence seq = new MockTurnNumberSequence(0);
		TicketDispenser td1 = new TicketDispenser(seq);
		TicketDispenser td2 = new TicketDispenser(seq);
		
		Assert.assertEquals(0, td1.getTurnTicket().getTurnNumber());
		Assert.assertEquals(1, td2.getTurnTicket().getTurnNumber());
	}
	
	static class MockTurnNumberSequence implements ITurnNumberSequence {
		
		private int num;
		
		MockTurnNumberSequence(int num) {
			this.num = num;
		}

		public int getNextTurnNumber() {
			return num++;
		}
		
	}

}
