class TelemetryClient
  DIAGNOSTICMESSAGE = "AT#UD"

  attr_reader :diagnostic_message_result

  def initialize(connection_events_simulator=ConnectionEventsSimulator)
    @online_status = false
    @diagnostic_message_result = ""
    @connection_events_simulator = connection_events_simulator
  end

  def online? 
    @online_status
  end

  def connect(telemetry_server_connection_string)
    raise ArgumentNullException if String.null_or_empty?(
      telemetry_server_connection_string)

    #simulate the operation on a real modem
    success = 
      @connection_events_simulator.connect(1, 10) <= 8
    @online_status = success
  end

  def disconnect 
    @online_status = false
  end

  def send(message)
    raise ArgumentNullException if String.null_or_empty?(
      message) 

    if (message == DIAGNOSTICMESSAGE)
      #simulate a status report
      @diagnostic_message_result = "some failure message"
      return
    end
    #here should go the real Send operation
  end

  def receive 
    if !String.null_or_empty?(@diagnostic_message_result)
      message = @diagnostic_message_result
      reset_diagnostic_message
    else
      #simulate a received message
      message = receive_message_in_non_failure_case
    end

    message
  end

  private
  def reset_diagnostic_message
    @diagnostic_message_result = ""
  end

  def receive_message_in_non_failure_case
      message = "" 
      message_length = 
        @connection_events_simulator.connect(65, 110) 
      while message_length >= 0
        message += 
          @connection_events_simulator.connect(40, 126).chr
        message_length -= 1
      end
      message
  end
end

class ArgumentNullException < Exception
end

class ConnectionEventsSimulator
  def self.connect(base_number, upper_bound)
    base_number + rand(upper_bound)
  end
end

class String
  def self.null_or_empty?(str)
    str.nil? || str == ""
  end
end
