import unittest

from tire_pressure_monitoring import Alarm

class AlarmTest(unittest.TestCase):

    def test_do_something(self):
        alarm = Alarm()
        alarm.check()
        alarm.is_alarm_on


if __name__ == "__main__":
	unittest.main()