package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

/**
 * Created by ben on 14-4-11.
 */
public class SensorTest {
    @Test
    public void when_pop_next_pressure_psi_value_then_get_characterization() {
        assertThat(sensor.popNextPressurePsiValue()).isEqualTo(0);
    }
}
