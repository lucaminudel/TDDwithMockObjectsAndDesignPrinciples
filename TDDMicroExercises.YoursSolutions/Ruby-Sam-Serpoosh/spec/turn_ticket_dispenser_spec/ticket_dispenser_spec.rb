require_relative "../../code/turn_ticket_dispenser/ticket_dispenser"


describe TicketDispenser do
  it "gets the next ticket" do
    TurnNumberSequence.stub(:get_next_turn_number => 2)
    ticket_dispenser = TicketDispenser.new
    
    ticket = ticket_dispenser.get_turn_ticket
    ticket.turn_number.should == 2
  end
end
