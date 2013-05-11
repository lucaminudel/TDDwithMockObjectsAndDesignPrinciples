<?php

namespace TDDMicroExercises\PHP\TelemetrySystem;

class TelemetryClient
{
	const DiagnosticMessage = "AT#UD";

	private $_onlineStatus;
	private $_diagnosticMessageJustSent = false;

	/*private $_connectionEventsSimulator = new Random();
    private $_randomMessageSimulator 	= new Random();*/

    public function getOnlineStatus()
    {
    	return $this->_onlineStatus;
    }

    public function connect( $telemetryServerConnectionString )
    {
    	if( is_null($telemetryServerConnectionString) || empty($telemetryServerConnectionString) ) 
    	{
    		throw new \InvalidArgumentException();
    	}

    	// Fake the connection with 20% chances of success
		//$success = rand(1, 10) <= 2;
		$success = rand(1, 10) <= 2;
		$this->_onlineStatus = $success;
    }

    public function disconnect()
    {
    	$this->_onlineStatus = false;
    }

    public function send( $message )
    {
    	if( is_null($message) || empty($message) ) {
    		throw new \InvalidArgumentException();
    	}

    	// The simulation of Send() actually just remember if the last message sent was a diagnostic message.
        // This information will be used to simulate the Receive(). Indeed there is no real server listening.
        if ( $message == TelemetryClient::DiagnosticMessage )
		{
		    $this->_diagnosticMessageJustSent = true;

		}
		else
		{
		    $this->_diagnosticMessageJustSent = false;
		}
	
    }

    public function receive()
    {
    	$message = '';

    	if($this->_diagnosticMessageJustSent)
    	{
    		// Simulate the reception of the diagnostic message
                $message = "LAST TX rate................ 100 MBPS\r\n"
                    . "HIGHEST TX rate............. 100 MBPS\r\n"
                    . "LAST RX rate................ 100 MBPS\r\n"
                    . "HIGHEST RX rate............. 100 MBPS\r\n"
                    . "BIT RATE.................... 100000000\r\n"
                    . "WORD LEN.................... 16\r\n"
                    . "WORD/FRAME.................. 511\r\n"
                    . "BITS/FRAME.................. 8192\r\n"
                    . "MODULATION TYPE............. PCM/FM\r\n"
                    . "TX Digital Los.............. 0.75\r\n"
                    . "RX Digital Los.............. 0.10\r\n"
                    . "BEP Test.................... -5\r\n"
                    . "Local Rtrn Count............ 00\r\n"
                    . "Remote Rtrn Count........... 00";

                $this->_diagnosticMessageJustSent = false;
    	}
    	else
    	{
    		$messageLength = rand( 50, 110 );
    		for($i = $messageLength; $i > 0; $i-- )
    		{
    			$message += chr( rand( 40, 126 ) ) ;
    		}
    	}

    	return $message;
    }
}