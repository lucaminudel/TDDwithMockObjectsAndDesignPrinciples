package tddmicroexercises.telemetrysystem;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TelemetryDiagnosticControlsTest
{
	
	private MockTelemetryClient tc;
	private TelemetryDiagnosticControls controls;
	
	@Before public void
	before() {
		tc = new MockTelemetryClient();
		controls = new TelemetryDiagnosticControls(tc);
	}
    
	@Test public void 
	disconnect_should_be_first_operation_on_telemetry_client() {
		try {
			controls.checkTransmission();
		} 
		catch(Exception e) {
			
		}
		finally {
			Assert.assertEquals(0, tc.messageIndex("disconnect"));
		}
    }
	
	@Test public void 
	should_connect_to_telemetry_client_using_correct_connection_string() {
		try {
			controls.checkTransmission();
		} 
		catch(Exception e) {
			
		}
		finally {
			Assert.assertEquals("*111#", tc.getConnectionString());
		}
    }
	
	@Test public void 
	should_try_to_connect_to_telemetry_client_three_times() {
		try {
			controls.checkTransmission();
		} 
		catch(Exception e) {
			
		}
		finally {
			Assert.assertEquals(3, tc.connectTries());
		}
    }
	
	@Test(expected = Exception.class) public void 
	should_throw_exception_if_unable_to_connect() throws Exception {
		try {
			tc.setOnlineStatus(false);
			controls.checkTransmission();
		} 
		catch(Exception e) {
			Assert.assertEquals("Unable to connect.", e.getMessage());
			throw e;
		}
    }
	
	@Test public void 
	should_send_diagnostic_message_to_telemetry_client_when_successfully_connected() throws Exception {
		try {
			tc.setOnlineStatus(true);
			controls.checkTransmission();
		}
		finally {
			Assert.assertEquals(ITelemetryClient.DIAGNOSTIC_MESSAGE, tc.getMessageSent());
		}
    }
	
	@Test public void 
	should_store_message_recieved_from_telemetry_client_when_successfully_connected() throws Exception {
		tc.setOnlineStatus(true);
		tc.setRecieve("test");
		controls.checkTransmission();
		Assert.assertEquals("test", controls.getDiagnosticInfo());
    }
	
	private static class MockTelemetryClient implements ITelemetryClient {
		
		private boolean onlineStatus;
		
		private List<String> methods = new ArrayList<String>();
		
		public int messageIndex(String method) {
			return methods.indexOf(method);
		}

		public boolean getOnlineStatus() {
			methods.add("onlineStatus");
			return onlineStatus;
		}
		
		public void setOnlineStatus(boolean onlineStatus) {
			this.onlineStatus = onlineStatus;
		}
		
		private int tries;
		private String connectionString;

		public void connect(String telemetryServerConnectionString) {
			methods.add("connect");
			tries++;
			connectionString = telemetryServerConnectionString;
		}
		
		public int connectTries() {
			return tries;
		}
		
		public String getConnectionString() {
			return connectionString;
		}
		
		private boolean disconnected;

		public void disconnect() {
			methods.add("disconnect");
			disconnected = true;
		}
		
		public boolean isDisconnected() {
			return disconnected;
		}
		
		private int sendCount;
		private String messageSent;

		public void send(String message) {
			methods.add("send");
			messageSent = message;
			sendCount++;
		}
		
		public String getMessageSent() {
			return messageSent;
		}
		
		public int sendCount() {
			return sendCount;
		}
		
		private String recieveMsg;

		public String receive() {
			methods.add("recieve");
			return recieveMsg;
		}
		
		public void setRecieve(String recieveMsg) {
			this.recieveMsg = recieveMsg;
		}
		
	}

}
