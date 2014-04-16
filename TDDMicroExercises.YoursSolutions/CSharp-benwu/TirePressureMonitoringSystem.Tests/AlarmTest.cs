using System;
using System.Collections.Generic;
using System.Text;
using Moq;
using NUnit.Framework;

namespace TDDMicroExercises.TirePressureMonitoringSystem.Tests
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void WHEN_check_pressure_value_in_alarm_THEN_get_characterization_of_whether_alarm_is_on()
        {
            // Given
            var sensor = new Mock<ISensor>();
            var alarm = new Alarm(sensor.Object);

            sensor
                .Setup(s => s.PopNextPressurePsiValue())
                .Returns(16.0);

            // When
            alarm.Check();

            // Then
            Assert.AreEqual(true, alarm.AlarmOn);
        }
    }
}
