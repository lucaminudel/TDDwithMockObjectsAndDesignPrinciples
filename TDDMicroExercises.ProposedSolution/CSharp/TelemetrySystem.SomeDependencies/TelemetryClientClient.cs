namespace TDDMicroExercises.OneSolution.TelemetrySystem.SomeDependencies
{
    public class TelemetryClientClient
    {
		// A class with the only goal of simulating a dependency on TelemetryClient
		// that has impact on the refactoring.

		public TelemetryClientClient()
        {
            var tc = new TelemetryClientConnection();
            if (!tc.OnlineStatus)
                tc.Connect("a connection string");

            var tdata = new TelemetryDataChannel();

            tdata.Send("some message");

            var response = tdata.Receive();

            tc.Disconnect();

        }
    }
}
