describe('Tyre Pressure Monitoring System', function () {

	describe('Alarm', function () {

		var stubSensor;
		var target;

		beforeEach(function () {
			stubSensor = a.stub(Sensor);
			target = new Alarm(stubSensor);
		});

		it('a normal pressure value should not raise the alarm', function () {
			spyOn(stubSensor, 'popNextPressurePsiValue').andCallFake(function () { return Alarm.LowPressureThreshold() +2; });

			target.check();

			expect(target.alarmOn()).toBeFalsy();
		});

		it('a pressure value out of range should raise the alarm', function () {
			spyOn(stubSensor, 'popNextPressurePsiValue').andCallFake(function () { return Alarm.HighPressureThreshold() +1; });

			target.check();

			expect(target.alarmOn()).toBeTruthy();
		});


		it('a normal pressure value after an out of range pressure value should keep the alarm on', function () {
			var sensorValueStream = [Alarm.HighPressureThreshold() +1, Alarm.LowPressureThreshold() +2];
			spyOn(stubSensor, 'popNextPressurePsiValue').andCallFake(function () { return sensorValueStream.pop(); });

			target.check();
			target.check();

			expect(target.alarmOn()).toBeTruthy();
		});

	});

});
