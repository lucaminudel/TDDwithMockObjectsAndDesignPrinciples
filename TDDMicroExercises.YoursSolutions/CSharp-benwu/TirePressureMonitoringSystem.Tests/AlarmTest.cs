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
        public void GIVEN_pressure_psi_value_is_16_WHEN_check_pressure_value_in_alarm_THEN_alarm_is_on()
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
            Assert.IsTrue(alarm.AlarmOn);
            sensor.Verify(s => s.PopNextPressurePsiValue());
        }

        [Test]
        public void GIVEN_pressure_psi_value_is_17_WHEN_check_pressure_value_in_alarm_THEN_alarm_is_off()
        {
            // Given
            var sensor = new Mock<ISensor>();
            var alarm = new Alarm(sensor.Object);

            sensor
                .Setup(s => s.PopNextPressurePsiValue())
                .Returns(17.0);

            // When
            alarm.Check();

            // Then
            Assert.IsFalse(alarm.AlarmOn);
            sensor.Verify(s => s.PopNextPressurePsiValue());
        }
    }
}
