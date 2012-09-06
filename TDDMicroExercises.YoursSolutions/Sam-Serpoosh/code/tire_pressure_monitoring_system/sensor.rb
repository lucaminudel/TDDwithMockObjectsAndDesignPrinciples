class Sensor
  OFFSET = 16;

  def pop_next_pressure_psi_value 
    OFFSET + generate_sample_pressure
  end

  def generate_sample_pressure
    #placeholder implementation that simulate 
    #a real sensor in a real tire
    rand(6) * rand(6) 
  end
end
