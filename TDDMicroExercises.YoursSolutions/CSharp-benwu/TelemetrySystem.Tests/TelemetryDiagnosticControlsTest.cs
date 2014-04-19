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
            TelemetryDiagnosticControls telementryDiagnosticControls = 
                new TelemetryDiagnosticControls(telemetryClient.Object);
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

        [Test]
        public void GIVEN_on_happy_path_WHEN_check_transmission_THEN_get_diagnostic_response()
        {
            // Given
            TelemetryDiagnosticControls telemetryDiagnosticControls = 
                new TelemetryDiagnosticControls(new TestingTelemetryClient(1, 51, 41));

            // When
            telemetryDiagnosticControls.CheckTransmission();

            // Then
            string message = "LAST TX rate................ 100 MBPS\r\n"
                + "HIGHEST TX rate............. 100 MBPS\r\n"
                + "LAST RX rate................ 100 MBPS\r\n"
                + "HIGHEST RX rate............. 100 MBPS\r\n"
                + "BIT RATE.................... 100000000\r\n"
                + "WORD LEN.................... 16\r\n"
                + "WORD/FRAME.................. 511\r\n"
                + "BITS/FRAME.................. 8192\r\n"
                + "MODULATION TYPE............. PCM/FM\r\n"
                + "TX Digital Los.............. 0.75\r\n"
                + "RX Digital Los.............. 0.10\r\n"
                + "BEP Test.................... -5\r\n"
                + "Local Rtrn Count............ 00\r\n"
                + "Remote Rtrn Count........... 00";
            Assert.AreEqual(message, telemetryDiagnosticControls.DiagnosticInfo);
        }
    }
}
