package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.*;

public class AlarmTest {
    @Test
    public void canCreatAlarmWithGivenSensor() {
	new Alarm(mock(ISensor.class));
    }

    @Test
    public void aNewAlarmIsOff() {
        assertThat((new Alarm()).isAlarmOn(), is(FALSE));
    }

    @Test
    public void alarmIsOnWhenSensorValueBelowThreshold() {
	ISensor sensor = mock(ISensor.class);
	when(sensor.popNextPressurePsiValue()).thenReturn(0D);
	Alarm alarm = new Alarm(sensor);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(TRUE));
    }

}
