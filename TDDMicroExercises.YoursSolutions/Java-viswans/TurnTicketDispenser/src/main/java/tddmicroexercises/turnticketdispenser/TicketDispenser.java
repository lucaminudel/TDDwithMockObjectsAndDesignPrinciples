package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
	
	private ITurnNumberSequence seq;
	
	@Deprecated
	public TicketDispenser() {
		this.seq = new ITurnNumberSequence() {
			
			public int getNextTurnNumber() {
				return TurnNumberSequence.getNextTurnNumber();
			}
			
		};
	}
	
	public TicketDispenser(ITurnNumberSequence seq) {
		this.seq = seq;
	}
	
    public TurnTicket getTurnTicket()
    {
        return _getTurnTicket();
    }
    
    private TurnTicket _getTurnTicket() {
    	int newTurnNumber = seq.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);
        return newTurnTicket;
    }
    
}
