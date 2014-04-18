using Moq;
using NUnit.Framework;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void WHEN_check_Transmision_THEN_diagnostic_request_should_be_sent_and_message_should_be_got()
        {
            var telemetryClient = new Mock<TelemetryClient>();

            telemetryClient
                .Setup(t => t.Send(TelemetryClient.DiagnosticMessage));

            telemetryClient
                .Setup(t => t.Receive())
                .Returns("LAST TX rate................ 100 MBPS\r\n");

            TelemetryDiagnosticControls telementryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient.Object);
            telementryDiagnosticControls.CheckTransmission();
            Assert.AreEqual("", telementryDiagnosticControls.DiagnosticInfo);
        }
    }
}
