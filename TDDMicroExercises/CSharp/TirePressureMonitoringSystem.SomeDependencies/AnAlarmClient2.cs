using System;
namespace TDDMicroExercises.TirePressureMonitoringSystem.SomeDependencies
{
    public class AnAlarmClient2
    {
		// A class with the only goal of simulating a dependency on Alert
		// that has impact on the refactoring.
		
        private void DoSomething()
        {
            Alarm anAlarm = new Alarm();
            anAlarm.Check();
            bool isAlarmOn = anAlarm.AlarmOn;
        }
    }
}
