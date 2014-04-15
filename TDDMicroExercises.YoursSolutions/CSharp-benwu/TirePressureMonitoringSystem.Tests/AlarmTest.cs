using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace TDDMicroExercises.TirePressureMonitoringSystem.Tests
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void WHEN_check_pressure_value_in_alarm_THEN_get_characterization_of_whether_alarm_is_on()
        {
            Alarm alarm = new Alarm();
            alarm.Check();
            Assert.AreEqual(true, alarm.AlarmOn);
        }
    }
}
