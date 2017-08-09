package tddmicroexercises.tirepressuremonitoringsystem.somedependencies;

import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

public class AnAlarmClient1
{
    // A class with the only goal of simulating a dependency on Alert
    // that has impact on the refactoring.

    public AnAlarmClient1()
    {
        Alarm anAlarm = new Alarm();
        anAlarm.check();
        boolean isAlarmOn = anAlarm.isAlarmOn();
    }
}
