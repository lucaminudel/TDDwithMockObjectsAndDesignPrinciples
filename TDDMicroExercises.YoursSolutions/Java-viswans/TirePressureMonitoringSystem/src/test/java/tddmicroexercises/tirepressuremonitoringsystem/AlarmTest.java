package tddmicroexercises.tirepressuremonitoringsystem;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlarmTest {
	
	private Range validPressureRange;
	private MockSensor high, low, okay;
	
	@Before public void 
	before() {
		validPressureRange = new Range(Alarm.LowPressureThreshold, Alarm.HighPressureThreshold);
		low = new MockSensor(16);
		okay = new MockSensor(19);
		high = new MockSensor(22);
	}
	
	@After public void
	after() {
		validPressureRange = null;
		high = low = okay = null;
	}
	
	@Test public void
	should_sense_pressure_sensor_once_on_check() {
		Alarm al = new Alarm(okay, validPressureRange);
		al.check();
		Assert.assertEquals(1, okay.timesSensed());
	}
	
	@Test public void
	should_turn_alarm_on_when_pressure_low() {
		Alarm al = new Alarm(low, validPressureRange);
		al.check();
		Assert.assertTrue(al.isAlarmOn());
	}
	
	@Test public void
	should_turn_alarm_on_when_pressure_high() {
		Alarm al = new Alarm(high, validPressureRange);
		al.check();
		Assert.assertTrue(al.isAlarmOn());
	}
	
	@Test public void
	should_not_turn_alarm_on_when_pressure_normal() {
		Alarm al = new Alarm(okay, validPressureRange);
		al.check();
		Assert.assertFalse(al.isAlarmOn());
	}
	
	@Test public void
	should_not_turn_alarm_off_once_alarm_on() {
		MockSensor sen = new MockSensor(0);
		Alarm al = new Alarm(sen, validPressureRange);
		
		al.check();
		sen.set(20);
		al.check();
		
		Assert.assertTrue(al.isAlarmOn());
	}
	
	static class MockSensor implements ISensor {
		
		private int sensed;
		private double val;
		
		public MockSensor(double val) {
			this.val = val;
		}
		
		public void set(double val) {
			this.val = val;
		}

		public double popNextPressurePsiValue() {
			sensed += 1;
			return val;
		}
		
		public int timesSensed() {
			return sensed;
		}
		
	}

}
