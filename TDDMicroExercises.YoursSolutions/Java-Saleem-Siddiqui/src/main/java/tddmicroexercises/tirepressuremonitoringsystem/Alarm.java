package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private ISensor sensor;

    private boolean alarmOn = false;

    public Alarm(ISensor sensor) {
	this.sensor = sensor;
    }

    public Alarm() {
	this(new Sensor());
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
	    {
		alarmOn = true;
	    }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
