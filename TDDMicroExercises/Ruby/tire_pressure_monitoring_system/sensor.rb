class Sensor
    OFFSET = 16;

    def pop_next_pressure_psi_value 
      pressure_telemetry_value = sample_pressure 
      OFFSET + pressure_telemetry_value;
    end

    def sample_pressure 
      #placeholder implementation that 
      #simulate a real sensor in a real tire
      pressure_telemetry_value = 6 * rand(5) * rand(4) 
      pressure_telemetry_value
    end
end
