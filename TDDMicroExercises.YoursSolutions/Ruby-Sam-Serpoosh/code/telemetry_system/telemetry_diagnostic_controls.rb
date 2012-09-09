require_relative "./telemetry_client"

class TelemetryDiagnosticControls
  DIAGNOSTICCHANNELCONNECTIONSTRING = "*111#"
  NUMBEROFRETRIES = 3

  attr_accessor :diagnostic_info

  def initialize(telemetry_client=TelemetryClient.new)
    @telemetry_client = telemetry_client 
    @diagnostic_info = "" 
  end

  def check_transmission 
    @telemetry_client.disconnect
    try_to_connect

    raise UnableToConnectException if(@telemetry_client.
      online? == false)

    @telemetry_client.send(TelemetryClient::DIAGNOSTICMESSAGE)
    @diagnostic_info = @telemetry_client.receive
  end

  private
  def try_to_connect
    retry_left = NUMBEROFRETRIES 
    while still_try?(retry_left)
      @telemetry_client.connect(DIAGNOSTICCHANNELCONNECTIONSTRING)
      retry_left -= 1
    end
  end

  def still_try?(retry_left)
    @telemetry_client.online? == false && 
      retry_left > 0
  end
end

class UnableToConnectException < Exception
end
