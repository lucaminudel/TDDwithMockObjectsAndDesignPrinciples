<?php

namespace TDDMicroExercises\PHP\TirePressureMonitoringSystem;

class Sensor 
{
	const OFFSET = 16;

	public static function SamplePressure()
	{
		// placeholder implementation that simulate a real sensor in a real tire
		$pressureTelemetryValue = floor(6 * rand() * rand());
		return $pressureTelemetryValue;
	}

	public function popNextPressurePsiValue() 
	{
		$pressureTelemetryValue = self::SamplePressure();
		return self::OFFSET + $pressureTelemetryValue;
	}
}