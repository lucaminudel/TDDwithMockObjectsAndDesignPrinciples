require_relative "./turn_number_sequence"
require_relative "./turn_ticket"

class TicketDispenser

  def initialize(ticket_sequence_generator=TurnNumberSequence)
    @ticket_sequence_generator = ticket_sequence_generator
  end

  def get_turn_ticket 
    new_turn_number = @ticket_sequence_generator.get_next_turn_number
    TurnTicket.new(new_turn_number)
  end
end
