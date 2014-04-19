namespace TDDMicroExercises.TelemetrySystem.Tests
{
    public class TestingTelemetryClient : TelemetryClient
    {
        private int _connectionEventsRandomNumberFrom1To10;
        private int _messageRandomNumberFrom50To110;
        private int _messageRandomNumberFrom40To126;

        public TestingTelemetryClient(int connectionEventsRandomNumberFrom1To10, int messageRandomNumberFrom50To110, int messageRandomNumberFrom40To126)
        {
            this._connectionEventsRandomNumberFrom1To10 = connectionEventsRandomNumberFrom1To10;
            this._messageRandomNumberFrom50To110 = messageRandomNumberFrom50To110;
            this._messageRandomNumberFrom40To126 = messageRandomNumberFrom40To126;
        }

        public override void Connect(string telemetryServerConnectionString)
        {
            this.Connect(telemetryServerConnectionString, _connectionEventsRandomNumberFrom1To10);
        }

        public override string Receive()
        {
            return this.Receive(_messageRandomNumberFrom50To110, _messageRandomNumberFrom40To126);
        }
    }
}