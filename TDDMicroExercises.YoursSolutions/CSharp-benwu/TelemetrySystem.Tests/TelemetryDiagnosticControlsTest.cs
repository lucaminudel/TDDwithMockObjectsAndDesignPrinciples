using NUnit.Framework;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void WHEN_check_Transmision_THEN_get_characterization()
        {
            TelemetryDiagnosticControls telementryDiagnosticControls = new TelemetryDiagnosticControls();
            telementryDiagnosticControls.CheckTransmission();
            Assert.AreEqual("", telementryDiagnosticControls.DiagnosticInfo);
        }
    }
}
