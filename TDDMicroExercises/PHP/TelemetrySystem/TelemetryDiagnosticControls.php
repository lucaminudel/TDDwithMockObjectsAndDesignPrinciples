<?php

namespace TDDMicroExercises\PHP\TelemetrySystem;

class TelemetryDiagnosticControls
{
	const DiagnosticChannelConnectionString = "*111#";

	private $_telemetryClient;
	private $_diagnosticInfo = '';

	public function __construct()
	{
		$this->_telemetryClient = new TelemetryClient();
	}

	public function getDiagnosticInfo()
	{
		return $this->_diagnosticInfo;
	}

	public function setDiagnosticInfo( $diagnosticInfo )
	{
		$this->_diagnosticInfo = $diagnosticInfo;
	}

	public function checkTransmission()
	{
		$this->_diagnosticInfo = '';
		$this->_telemetryClient->disconnect();

		$retryLeft = 3;
		while ( $this->_telemetryClient->getOnlineStatus() == false && $retryLeft > 0 ) 
		{
			$this->_telemetryClient->connect(
				TelemetryDiagnosticControls::DiagnosticChannelConnectionString
			);
			$retryLeft -= 1;
		}

		if($this->_telemetryClient->getOnlineStatus() == false)
		{
			throw new \Exception('Unable to connect.');
		}

		$this->_telemetryClient->send(TelemetryClient::DiagnosticMessage);
		$this->_diagnosticInfo = $this->_telemetryClient->receive();
	}
}