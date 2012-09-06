class TurnNumberSequence
  @@current_turn_number = -1

  def self.get_next_turn_number
    @@current_turn_number += 1
  end
end
