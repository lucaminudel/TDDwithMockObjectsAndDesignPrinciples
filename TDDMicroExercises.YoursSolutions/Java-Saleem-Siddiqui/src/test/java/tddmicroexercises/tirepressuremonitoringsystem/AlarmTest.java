package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlarmTest {
    @Mock private ISensor sensor;

    @Before
    public void setUp() {
	initMocks(this);
    }

    @Test
    public void canCreateAlarmWithGivenSensor() {
	new Alarm(sensor);
    }

    @Test
    public void aNewAlarmIsOff() {
        assertThat((new Alarm()).isAlarmOn(), is(FALSE));
    }

    @Test
    public void alarmIsOnWhenSensorValueBelowThreshold() {
	when(sensor.popNextPressurePsiValue()).thenReturn(0D);
	Alarm alarm = new Alarm(sensor);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(TRUE));
    }
}
