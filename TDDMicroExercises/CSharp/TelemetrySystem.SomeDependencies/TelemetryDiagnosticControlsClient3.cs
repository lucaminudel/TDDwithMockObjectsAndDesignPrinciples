using System;
namespace TDDMicroExercises.TelemetrySystem.SomeDependencies
{
    public class TelemetryDiagnosticControlsClient3
    {
		// A class with the only goal of simulating a dependency on TelemetryDiagnosticControls
		// that has impact on the refactoring.

		public TelemetryDiagnosticControlsClient3()
		{
			var teleDiagnostic = new TelemetryDiagnosticControls();

			teleDiagnostic.CheckTransmission();

			var result = teleDiagnostic.DiagnosticInfo;
		}
    }
}
