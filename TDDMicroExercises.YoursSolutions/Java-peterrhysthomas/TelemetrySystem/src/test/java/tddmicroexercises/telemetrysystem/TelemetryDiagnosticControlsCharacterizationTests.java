package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
/**
 * Characterization test class for testing existing behaviour of 
 * {@link TelemetryDiagnosticControls} before refactoring.
 *
 */
public class TelemetryDiagnosticControlsCharacterizationTests{
	@Test
	public void checkTransmissionShouldSetDiagnosticInfo() throws Exception{
		TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls();
		
		controls.checkTransmission();
		
		assertNotNull(controls.getDiagnosticInfo());
	}
	
}
