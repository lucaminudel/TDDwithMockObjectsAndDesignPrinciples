require_relative './sensor'

class Alarm

  attr_reader :alarm_on

  def initialize
    @sensor = Sensor.new
    @alarm_on = false
  end

  def check
    pressure = @sensor.pop_next_pressure_psi_value()

    @alarm_on = true if pressure < LOW_PRESSURE || HIGH_PRESSURE < pressure
    end

private

  LOW_PRESSURE = 17
  HIGH_PRESSURE = 21
end
