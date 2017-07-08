using System;
namespace TDDMicroExercises.TelemetrySystem.SomeDependencies
{
    public class TelemetryDiagnosticControlsClient2
    {
		// A class with the only goal of simulating a dependency on TelemetryDiagnosticControls
		// that has impact on the refactoring.

		public TelemetryDiagnosticControlsClient2()
		{
			var teleDiagnostic = new TelemetryDiagnosticControls();

			teleDiagnostic.CheckTransmission();

			var result = teleDiagnostic.DiagnosticInfo;
		}
    }
}
