
Alarm = function(sensor) {

	this._sensor = sensor;
	this._alarmOn = false;
};

Alarm.Create = function() {
	return new Alarm(new Sensor());
};

Alarm.LowPressureThreshold = function() {
    return 17;
};

Alarm.HighPressureThreshold = function() {
    return 21;
};

Alarm.prototype = {

	check: function () {
		
		var psiPressureValue = this._sensor.popNextPressurePsiValue();

		if (psiPressureValue < Alarm.LowPressureThreshold() || Alarm.HighPressureThreshold()  < psiPressureValue)
		{
			this._alarmOn = true;
		}
	},
	
	alarmOn: function () {
		 return this._alarmOn;
	}

};
