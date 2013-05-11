<?php

namespace TDDMicroExercises\PHP\TurnTicketDispenser;

class TurnTicket
{
	private $_turnNumber;

    public function __construct($turnNumber)
    {
        $this->_turnNumber = $turnNumber;
    }

    public function getTurnNumber()
    {
        return $this->_turnNumber;
    }
}