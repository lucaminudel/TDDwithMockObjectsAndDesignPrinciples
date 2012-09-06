require_relative "./sensor"

class Alarm
    LOWPRESSURETHRESHOLD = 17
    HIGHPRESSURETHRESHOLD = 21

    def initialize
      @sensor = Sensor.new 
      @alarm_on = false
      @alarm_count = 0
    end

    def check
      psi_pressure_value = @sensor.pop_next_pressure_psi_value
      if psi_pressure_value < LOWPRESSURETHRESHOLD || HIGHPRESSURETHRESHOLD < psi_pressure_value 
          @alarm_on = true
          @alarm_count += 1
      end
    end

    def alarm_on 
      return @alarm_on 
    end
end
