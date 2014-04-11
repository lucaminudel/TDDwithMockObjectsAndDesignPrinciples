package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by ben on 14-4-11.
 */
public class AlarmTest {
    @Test
    public void when_check_alarm_then_get_characterization() {
        Alarm alarm = new Alarm();
        alarm.check();
        assertThat(alarm.isAlarmOn()).isEqualTo(false);
    }
}
