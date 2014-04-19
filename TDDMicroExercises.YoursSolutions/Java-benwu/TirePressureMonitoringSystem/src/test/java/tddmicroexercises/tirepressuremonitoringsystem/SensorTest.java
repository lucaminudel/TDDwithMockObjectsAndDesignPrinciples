package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by ben on 14-4-11.
 */
public class SensorTest {
    @Test
    public void when_pop_next_pressure_psi_value_then_it_is_between_18_and_19() {
        Sensor sensor = new Sensor();
        sensor.popNextPressurePsiValue();
        assertThat(sensor.popNextPressurePsiValue()).isGreaterThan(18.0).isLessThan(19.0);
    }
}
