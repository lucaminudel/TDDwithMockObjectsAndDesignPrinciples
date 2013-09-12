TelemetryClientConnection = function() {

	this._onlineStatus = false;
	
};

TelemetryClientConnection.prototype = {

	_connectionEventsSimulator: function (min, max) {
		var delta = max + 1 - min;
		return min + Math.floor(delta * Math.random());
	},

	onlineStatus: function () {
		return this._onlineStatus;
	},
	
	connect: function(telemetryServerConnectionString) {
		if (typeof(telemetryServerConnectionString) === 'undefined' || telemetryServerConnectionString === '') {
			throw 'missing telemetryServerConnectionString parameter';
		}

        // Fake the connection with 20% chances of success
        var success = this._connectionEventsSimulator(1, 10) <= 2;

		this._onlineStatus = success;
	},
	
	disconnect: function () {
		this._onlineStatus = false;
	}

};
