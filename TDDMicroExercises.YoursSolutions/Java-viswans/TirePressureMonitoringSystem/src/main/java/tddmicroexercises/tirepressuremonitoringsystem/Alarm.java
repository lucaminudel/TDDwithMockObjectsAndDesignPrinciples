package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double LowPressureThreshold = 17;
    public static final double HighPressureThreshold = 21;

    private ISensor sensor;	
    private Range validPressureRange;

    private boolean alarmOn = false;
    
    public Alarm(ISensor sensor, Range validPressureRange) {
    	this.sensor = sensor;
    	this.validPressureRange = validPressureRange;
	}

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (!validPressureRange.inRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
    
}
