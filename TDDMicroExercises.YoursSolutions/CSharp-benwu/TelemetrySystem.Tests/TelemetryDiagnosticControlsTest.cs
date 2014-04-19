using Moq;
using NUnit.Framework;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void GIVEN_online_status_of_TelemetryClient_is_tue_WHEN_check_Transmision_THEN_method_Disconnect_Send_and_Receive_should_be_invoked()
        {
            // Given
            var telemetryClient = new Mock<TelemetryClient>();
            TelemetryDiagnosticControls telementryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient.Object);
            telemetryClient
                .Setup(t => t.OnlineStatus)
                .Returns(true);

            // When
            telementryDiagnosticControls.CheckTransmission();

            // Then
            telemetryClient.Verify(t => t.Disconnect());
            // telemetryClient.Verify(t => t.Connect("*111#")); // Why this line never performed?
            telemetryClient.Verify(t => t.Send("AT#UD"));
            telemetryClient.Verify(t => t.Receive());
        }
    }
}
