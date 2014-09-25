package tddmicroexercises.telemetrysystem;

public interface ITelemetryClient {

	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

	boolean getOnlineStatus();

	void connect(String telemetryServerConnectionString);

	void disconnect();

	void send(String message);

	String receive();

}