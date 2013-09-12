using NUnit.Framework;

namespace TDDMicroExercises.OneSolution.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
        {
            var stubTelemetryConnection = new StubTelemetryConnection();
            stubTelemetryConnection.StubGetOnlineStatus(true);

            var mockTelemetryDataChannel = new MockTelemetryDataChannel();
            mockTelemetryDataChannel.SetExpectedCallToSend(TelemetryDataChannel.DiagnosticMessage);
            mockTelemetryDataChannel.SetExpectedCallToReceive("status report");

            var target = new TelemetryDiagnosticControls(stubTelemetryConnection, mockTelemetryDataChannel);


            target.CheckTransmission();


            mockTelemetryDataChannel.Verify();
            Assert.AreEqual(target.DiagnosticInfo, "status report", "diagnostic info");
        }

    }
}
