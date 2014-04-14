using System;

namespace TDDMicroExercises.TelemetrySystem
{
	public class TelemetryClient
	{
        //
        // The communication with the server is simulated in this implementation.
        // Because the focus of the exercise is on the other class.
        //

		public const string DiagnosticMessage = "AT#UD";

		private bool _onlineStatus;
		private bool _diagnosticMessageJustSent = false;

        private readonly Random _connectionEventsSimulator = new Random();
        private readonly Random _randomMessageSimulator = new Random();

		public bool OnlineStatus
		{
			get { return _onlineStatus; }
		}

		public void Connect(string telemetryServerConnectionString)
		{
			if (string.IsNullOrEmpty(telemetryServerConnectionString))
			{
				throw new ArgumentNullException();
			}

			// Fake the connection with 20% chances of success
			bool success = _connectionEventsSimulator.Next(1, 10) <= 2;

			_onlineStatus = success;

		}

		public void Disconnect()
		{
			_onlineStatus = false;
		}

		public void Send(string message)
		{
			if (string.IsNullOrEmpty(message))
			{
				throw new ArgumentNullException();
			}

            // The simulation of Send() actually just remember if the last message sent was a diagnostic message.
            // This information will be used to simulate the Receive(). Indeed there is no real server listening.
            if (message == DiagnosticMessage)
			{
			    _diagnosticMessageJustSent = true;
			}
			else
			{
			    _diagnosticMessageJustSent = false;
			}
		}

		public string Receive()
		{
			string message;

            if (_diagnosticMessageJustSent)
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

                _diagnosticMessageJustSent = false;
			} 
			else
			{                
				// Simulate the reception of a response message returning a random message.
				message = string.Empty;
                int messageLength = _randomMessageSimulator.Next(50, 110);
				for(int i = messageLength; i > 0; --i)
				{
                    message += (char)_randomMessageSimulator.Next(40, 126);
				}
			}

			return message;
		}
	}
}
