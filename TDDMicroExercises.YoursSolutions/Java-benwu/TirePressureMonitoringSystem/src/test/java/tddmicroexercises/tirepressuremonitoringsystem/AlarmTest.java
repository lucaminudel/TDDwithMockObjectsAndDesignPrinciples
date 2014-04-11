package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

/**
 * Created by ben on 14-4-11.
 */
public class AlarmTest {
    @Test
    public void given_psi_pressure_value_is_less_than_17_when_check_then_alarm_is_on() {
        assertThat(alarm.isAlarmOn()).isEqualTo(true);
    }
}
