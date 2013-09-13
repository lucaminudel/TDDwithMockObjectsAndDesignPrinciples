class TurnNumberSequence
  @turn_number = 0

  def self.get_next_turn_number
    @turn_number += 1
  end
end
