<?php

namespace TDDMicroExercises\PHP\TirePressureMonitoringSystem;

class Sensor 
{
	const OFFSET = 16;

	public static function SamplePressure()
	{
		// placeholder implementation that simulate a real sensor in a real tire
		$pressureTelemetryValue = floor(6 * self::randomFloat(0, 1) * self::randomFloat(0, 1));
		return $pressureTelemetryValue;
	}

	public function popNextPressurePsiValue() 
	{
		$pressureTelemetryValue = self::SamplePressure();
		return self::OFFSET + $pressureTelemetryValue;
	}
	
	private static function randomFloat($min = 0, $max = 1)
	{
		return $min + mt_rand() / mt_getrandmax() * ($max - $min);
	}
}
