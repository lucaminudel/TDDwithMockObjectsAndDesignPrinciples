class TurnNumberSequence
  TURN_NUMBER = -1

  def self.get_next_turn_number
    TURN_NUMBER += 1
  end
end
