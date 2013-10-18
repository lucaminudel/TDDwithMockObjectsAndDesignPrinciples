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

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    @Mock private ISensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
	initMocks(this);
	alarm = new Alarm(sensor);
    }

    @Test
    public void aNewAlarmIsOff() {
        assertThat((new Alarm()).isAlarmOn(), is(FALSE));
    }

    @Test
    public void alarmIsOnWhenSensorValueBelowLowThreshold() {
	when(sensor.popNextPressurePsiValue()).thenReturn(0D);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(TRUE));
    }

    @Test
    public void alarmIsOnWhenSensorValueAboveHighThreshold() {
	when(sensor.popNextPressurePsiValue()).thenReturn(Double.MAX_VALUE);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(TRUE));
    }

    @Test
    public void alarmIsOffWhenValueEqualsLowThreshold() {
	when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(FALSE));
    }

    @Test
    public void alarmIsOffWhenValueEqualsHighThreshold() {
	when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);
	alarm.check();
	assertThat(alarm.isAlarmOn(), is(FALSE));
    }

    @Test
    public void findingIfAlarmIsOnDoesNotCallSensor() {
	alarm.isAlarmOn();
	verify(sensor, never()).popNextPressurePsiValue();
    }

    @Test
    public void checkingAlarmCallsSensor(){
	alarm.check();
	verify(sensor).popNextPressurePsiValue();
    }
}
