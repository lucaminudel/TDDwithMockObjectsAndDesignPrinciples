class TelemetryClient
  DIAGNOSTICMESSAGE = "AT#UD"

  def initialize
    @online_status = false
    @diagnostic_message_result = ""
  end

  def online_status
    @online_status
  end

  def connect(telemetry_server_connection_string)
    if (telemetry_server_connection_string.nil? || telemetry_server_connection_string == "")
      raise Exception, "Argument Null"
    end

    #simulate the operation on a real modem
    success = (1 + rand(10)) <= 8

    @online_status = success
  end

  def disconnect 
    @online_status = false
  end

  def send(message)
    if (message.nil? || message == "")
      raise Exception, "Argument Null"
    end

    if (message == DIAGNOSTICMESSAGE)
      #simulate a status report
      @diagnostic_message_result =
        "LAST TX rate................ 100 MBPS\nHIGHEST TX rate............. 100 MBPS\nLAST RX rate................ 100 MBPS\nHIGHEST RX rate............. 100 MBPS\nBIT RATE.................... 100000000\nWORD LEN.................... 16\nWORD/FRAME.................. 511\nBITS/FRAME.................. 8192\nMODULATION TYPE............. PCM/FM\nTX Digital Los.............. 0.75\nRX Digital Los.............. 0.10\nBEP Test.................... -5\nLocal Rtrn Count............ 00\nRemote Rtrn Count........... 00"

      return
    end

    #here should go the real Send operation
  end

  def receive 
    if (!@diagnostic_message_result.nil? && @diagnostic_message_result != "")
      message = @diagnostic_message_result
      @diagnostic_message_result = "" 
    else
      #simulate a received message
      message = "" 
      message_length = 50 + rand(110)
      i = message_length 
      while i >= 0
        message += (40 + rand(126)).chr
        i -= 1
      end
    end

    return message
  end
end
