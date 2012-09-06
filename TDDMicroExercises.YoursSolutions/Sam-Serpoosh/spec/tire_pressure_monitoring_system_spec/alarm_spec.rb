require_relative "../../code/tire_pressure_monitoring_system/alarm"

describe Alarm do
  context "#alarm_status" do
    it "turns on alarm when pressure is less than minimum threshold" do
      check_pressure(Alarm::LOWPRESSURETHRESHOLD - 1, true)
    end

    it "turns on alarm when pressure is greater than maximum threshold" do
      check_pressure(Alarm::HIGHPRESSURETHRESHOLD + 1, true)
    end

    it "turns off alarm when pressure is at the threshold" do
      check_pressure(Alarm::HIGHPRESSURETHRESHOLD, false)
    end 
  end

  context "#alarm_count" do
    it "increases nubmer of alarms after turning on the alarm" do
      alarm = create_alarm_with_stub_sensor(
        Alarm::HIGHPRESSURETHRESHOLD + 1)
      expect do
        alarm.check
      end.to change { alarm.alarm_count }.by 1
    end

    it "doesn't increase alarm counts when doesn't turn on alarm" do
      alarm = create_alarm_with_stub_sensor(
        Alarm::LOWPRESSURETHRESHOLD)
      expect do
        alarm.check
      end.not_to change { alarm.alarm_count }
    end
  end

  def check_pressure(stub_pressure, expected_alarm_status)
    alarm = create_alarm_with_stub_sensor(stub_pressure)
    alarm.check
    alarm.on?.should == expected_alarm_status
  end

  def create_alarm_with_stub_sensor(stub_pressure)
    sensor = stub(:pop_next_pressure_psi_value => stub_pressure)
    Alarm.new(sensor)
  end
end
