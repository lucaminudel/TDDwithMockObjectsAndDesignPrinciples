class Sensor
  # The reading of the pressure value from the sensor is simulated in this implementation.
  # Because the focus of the exercise is on the other class.

  OFFSET = 16
  private_constant :OFFSET

  def pop_next_pressure_psi_value
    OFFSET + read_sample_pressure()
  end

  def read_sample_pressure
    #Simulate info read from a real sensor in a real tire
    6 * rand * rand
  end
end
