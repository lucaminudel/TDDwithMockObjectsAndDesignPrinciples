package tddmicroexercises.telemetrysystem.somedependencies;

import tddmicroexercises.telemetrysystem.TelemetryClient;

public class TelemetryClientClient
{
    // A class with the only goal of simulating a dependency on TelemetryClient
    // that has impact on the refactoring.

    public TelemetryClientClient()
    {
        TelemetryClient tc = new TelemetryClient();
        if (!tc.getOnlineStatus())
            tc.connect("a connection string");

        tc.send("some message");

        String response = tc.receive();

        tc.disconnect();

    }
}
