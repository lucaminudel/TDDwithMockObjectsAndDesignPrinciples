require_relative './telemetry_client'

class TelemetryDiagnosticControls

  attr_reader :diagnostic_info

  def initialize 
    @telemetry_client = TelemetryClient.new 
    @diagnostic_info = ''
  end

  def check_transmission 
    @diagnostic_info = ''
    @telemetry_client.disconnect

    retry_left = 3
    while @telemetry_client.online_status == false && retry_left > 0
      @telemetry_client.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING)
      retry_left -= 1
    end

    if @telemetry_client.online_status == false
      raise Exception, 'Unable to connect.'
    end

    @telemetry_client.send(TelemetryClient::DIAGNOSTIC_MESSAGE)
    @diagnostic_info = @telemetry_client.receive
  end

private
  DIAGNOSTIC_CHANNEL_CONNECTION_STRING = '*111#'
end
