package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AlarmTestUsingCustomMock {
    private final class MockSensor implements ISensor {
	    private double _psiValue = 0D;
	    private int _popCount = 0;

	    @Override
	    public double popNextPressurePsiValue() {
		_popCalled();
		return _psiValue;
	    }
	    void _setPsiValue(double psiValue){
		this._psiValue = psiValue;
	    }
	    void _popCalled(){
		_popCount++;
	    }
	    int _getPopCallCount() {
		return _popCount;
	    }
	    void _resetPopCallCount() {
		_popCount = 0;
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
