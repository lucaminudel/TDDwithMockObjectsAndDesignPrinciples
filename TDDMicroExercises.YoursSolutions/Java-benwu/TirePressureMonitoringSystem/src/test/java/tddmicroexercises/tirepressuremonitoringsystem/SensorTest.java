package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by ben on 14-4-11.
 */
public class SensorTest {
    @Test
    public void when_pop_next_pressure_psi_value_then_get_characterization() {
        Sensor sensor = new Sensor();
        sensor.popNextPressurePsiValue();
        assertThat(sensor.popNextPressurePsiValue()).isGreaterThan(16.0);
    }
}
