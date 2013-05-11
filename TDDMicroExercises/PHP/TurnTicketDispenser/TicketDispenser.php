<?php

namespace TDDMicroExercises\PHP\TurnTicketDispenser;

class TicketDispenser
{

	public function getTurnTicket()
	{
		$newTurnNumber 	= TurnNumberSequence::getNextTurnNumber();
		$turnTicket 	= new TurnTicket($newTurnNumber);

		return $turnTicket;
	}
}