namespace TDDMicroExercises.TelemetrySystem.SomeDependencies
{
    public class TelemetryClientClient
    {
		// A class with the only goal of simulating a dependency on TelemetryClient
		// that has impact on the refactoring.

		public TelemetryClientClient()
        {
            var tc = new TelemetryClient();
            if (!tc.OnlineStatus)
                tc.Connect("a connection string");

            tc.Send("some message");

            var response = tc.Receive();

            tc.Disconnect();

        }
    }
}
