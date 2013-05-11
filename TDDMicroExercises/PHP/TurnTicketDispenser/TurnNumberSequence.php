<?php

namespace TDDMicroExercises\PHP\TurnTicketDispenser;

class TurnNumberSequence
{
	private static $_turnNumber = 0;

    public static function getNextTurnNumber()
    {
        return self::$_turnNumber++;
    }
}