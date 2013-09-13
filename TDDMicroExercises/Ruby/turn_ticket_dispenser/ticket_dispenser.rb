require_relative './turn_number_sequence'
require_relative './turn_ticket'

class TicketDispenser
  def get_turn_ticket 
    new_turn_number = TurnNumberSequence.get_next_turn_number()

    TurnTicket.new(new_turn_number)
  end
end
