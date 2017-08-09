package tddmicroexercises.telemetrysystem.somedependencies;

import tddmicroexercises.telemetrysystem.TelemetryDiagnosticControls;

public class TelemetryDiagnosticControlsClient1
{
    // A class with the only goal of simulating a dependency on TelemetryDiagnosticControls
    // that has impact on the refactoring.

    public TelemetryDiagnosticControlsClient1() throws Exception {

        TelemetryDiagnosticControls teleDiagnostic = new TelemetryDiagnosticControls();

        teleDiagnostic.checkTransmission();

        String result = teleDiagnostic.getDiagnosticInfo();
    }
}
