package tddmicroexercises.tirepressuremonitoringsystem.somedependencies;

import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

public class ASensorClient
{
    // A class with the only goal of simulating a dependency on Sensor
    // that has impact on the refactoring.

    public ASensorClient()
    {
        Sensor sensor = new Sensor();

        double value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
    }
}
