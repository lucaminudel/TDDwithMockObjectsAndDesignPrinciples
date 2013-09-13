require 'test/unit'
require_relative './ticket_dispenser'

class TicketDispenserTest < Test::Unit::TestCase


  def test_do_something
    td = TicketDispenser.new
    td.get_turn_ticket
    td.get_turn_ticket
    td.get_turn_ticket
  end
end