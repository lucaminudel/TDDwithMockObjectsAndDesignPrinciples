package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient
{
    //
    // The communication with the server is simulated in this implementation.
    // Because the focus of the exercise is on the other class.
    //

	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

	private boolean onlineStatus;
    private boolean diagnosticMessageJustSent = false;

    private final Random connectionEventsSimulator = new Random();
    private final Random randomMessageSimulator = new Random();

	public boolean getOnlineStatus()
	{
		return onlineStatus; 
	}

	public void connect(String telemetryServerConnectionString)
	{
		if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
		{
			throw new IllegalArgumentException();
		}

        // Fake the connection with 20% chances of success
		boolean success = connectionEventsSimulator.nextInt(10) <= 2;

		onlineStatus = success;
	}

	public void disconnect()
	{
		onlineStatus = false;
	}

	public void send(String message)
	{
		if (message == null || "".equals(message))
		{
			throw new IllegalArgumentException();
		}

        // The simulation of Send() actually just remember if the last message sent was a diagnostic message.
        // This information will be used to simulate the Receive(). Indeed there is no real server listening.
        if (message == DIAGNOSTIC_MESSAGE)
        {
            diagnosticMessageJustSent = true;
        }
        else
        {
            diagnosticMessageJustSent = false;
        }
    }

	public String receive()
	{
		String message;

        if (diagnosticMessageJustSent)
        {
            // Simulate the reception of the diagnostic message
            message = "LAST TX rate................ 100 MBPS\r\n"
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

            diagnosticMessageJustSent = false;
        }
        else
        {
            // Simulate the reception of a response message returning a random message.
            message = "";
            int messageLength = randomMessageSimulator.nextInt(50) + 60;
            for(int i = messageLength; i > 0; --i)
            {
                message += (char)randomMessageSimulator.nextInt(40) + 86;
            }
        }

		return message;
	}
}

