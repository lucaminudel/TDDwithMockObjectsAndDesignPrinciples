package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AlarmTestUsingCustomMock {
    private final class MockSensor implements ISensor {
	    private int _popCount = 0;

	    @Override
	    public double popNextPressurePsiValue() {
		_popCalled();
		return 0D;
	    }
	    void _popCalled(){
		_popCount++;
	    }
	    int _getPopCallCount() {
		return _popCount;
	    }
	};

    private MockSensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
	sensor = new MockSensor();
	alarm = new Alarm(sensor);
    }

    @Test
    public void findingIfAlarmIsOnDoesNotCallSensor() {
	alarm.isAlarmOn();
	assertThat(sensor._getPopCallCount(), is(0));
    }

    @Test
    public void checkingAlarmCallsSensor(){
	alarm.check();
	assertThat(sensor._getPopCallCount(), is(1));
    }
}
