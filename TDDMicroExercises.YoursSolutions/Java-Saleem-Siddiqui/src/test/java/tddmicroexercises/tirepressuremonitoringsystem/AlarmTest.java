package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlarmTest {
    @Test
    public void aNewAlarmIsOff() {
        assertThat((new Alarm()).isAlarmOn(), is(Boolean.FALSE));
    }
}
