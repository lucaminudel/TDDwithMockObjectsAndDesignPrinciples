require_relative "./sensor"

class Alarm
  LOWPRESSURETHRESHOLD = 17
  HIGHPRESSURETHRESHOLD = 21

  attr_reader :alarm_count

  def initialize(sensor=Sensor.new)
    @sensor = sensor 
    turn_off_alarm
    @alarm_count = 0
  end

  def check 
    psi_pressure = @sensor.pop_next_pressure_psi_value

    if dangerous_pressure?(psi_pressure)
      turn_on_alarm
      @alarm_count += 1
    end
  end

  def on? 
    @alarm_on
  end

  private
  def dangerous_pressure?(pressure)
    pressure < LOWPRESSURETHRESHOLD || 
      pressure > HIGHPRESSURETHRESHOLD
  end

  def turn_on_alarm
    @alarm_on = true
  end

  def turn_off_alarm
    @alarm_on = false
  end
end
