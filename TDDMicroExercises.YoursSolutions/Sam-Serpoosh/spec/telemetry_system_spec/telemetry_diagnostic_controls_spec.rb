require_relative "../../code/telemetry_system/telemetry_diagnostic_controls"

describe TelemetryDiagnosticControls do
  it "raises unable to connect when can't connect to client" do
    telemetry_client = stub(:online? => false).as_null_object
    controls = TelemetryDiagnosticControls.new(telemetry_client)
    lambda do
      controls.check_transmission
    end.should raise_error(UnableToConnectException)
  end

  it "tries to connect few times and when it can't raises exceptin" do
    telemetry_client = stub(:online? => false).as_null_object
    telemetry_client.should_receive(:connect).exactly(
      TelemetryDiagnosticControls::NUMBEROFRETRIES).times

    controls = TelemetryDiagnosticControls.new(telemetry_client)
    lambda do
      controls.check_transmission 
    end.should raise_error(UnableToConnectException)
  end

  it "connects and send and receive message with client" do
    receive_message = "this is from client"
    telemetry_client = stub(:online? => true).as_null_object
    telemetry_client.should_receive(:send).with(
      TelemetryClient::DIAGNOSTICMESSAGE)
    telemetry_client.should_receive(:receive).and_return(
      receive_message)

    controls = TelemetryDiagnosticControls.new(telemetry_client)
    controls.check_transmission
    controls.diagnostic_info.should == receive_message 
  end
end
