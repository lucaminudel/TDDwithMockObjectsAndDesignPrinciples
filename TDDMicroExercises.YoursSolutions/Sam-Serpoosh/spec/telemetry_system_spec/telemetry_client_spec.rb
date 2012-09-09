require_relative "../../code/telemetry_system/telemetry_client"

describe TelemetryClient do
  it "is not online at the beginning" do
    subject.should_not be_online
  end

  it "raises exception when connection string is nil or empty" do
    lambda do
      subject.connect(nil)
    end.should raise_error(ArgumentNullException)
  end

  it "becomes online when connect to it" do
    good_connection_range = 1
    StubConnectionEventsSimulator.stub(:connect => good_connection_range)
    client = TelemetryClient.new(StubConnectionEventsSimulator)
    client.connect("test server connection")
    client.should be_online
  end

  it "desn't become online when simulator can't connect" do
    bad_connection_range = 10
    StubConnectionEventsSimulator.stub(:connect => bad_connection_range)
    client = TelemetryClient.new(StubConnectionEventsSimulator)
    client.connect("test server connection")
    client.should_not be_online
  end

  it "can disconnect" do
    subject.disconnect
    subject.should_not be_online
  end

  it "raises exception when sending message is nil or empty" do
    lambda do
      subject.send(nil)
    end.should raise_error(ArgumentNullException)
  end

  it "doesn't send message when it's a diagnostic message" do
    subject.send(TelemetryClient::DIAGNOSTICMESSAGE)
    subject.diagnostic_message_result.should == "some failure message"
  end

  it "receives the diagnostic message if there is any and reset the diagnostic message" do
    subject.send(TelemetryClient::DIAGNOSTICMESSAGE)
    subject.receive.should == "some failure message"
    subject.diagnostic_message_result.should == ""
  end

  it "receives the message when there is no diagnostic message" do
    StubConnectionEventsSimulator.stub(:connect => 97)
    client = TelemetryClient.new(StubConnectionEventsSimulator)
    client.send("test server connection")
    client.receive.should == "a" * 98
  end
end

class StubConnectionEventsSimulator; end
