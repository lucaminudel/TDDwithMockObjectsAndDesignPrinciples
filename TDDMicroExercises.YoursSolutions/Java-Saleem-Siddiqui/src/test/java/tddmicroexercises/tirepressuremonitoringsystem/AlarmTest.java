package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.lang.Boolean.FALSE;
import static org.mockito.Mockito.mock;

public class AlarmTest {
    @Test
    public void canCreatAlarmWithGivenSensor() {
	new Alarm(mock(ISensor.class));
    }

    @Test
    public void aNewAlarmIsOff() {
        assertThat((new Alarm()).isAlarmOn(), is(FALSE));
    }
}
