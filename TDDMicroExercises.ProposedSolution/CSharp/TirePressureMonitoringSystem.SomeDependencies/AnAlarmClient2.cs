using System;
namespace TDDMicroExercises.OneSolution.TirePressureMonitoringSystem.SomeDependencies
{
    public class AnAlarmClient2
    {
		// A class with the only goal of simulating a dependency on Alart
		// that has impact on the refactoring.
		
        private void DoSomething()
        {
            Alarm anAlarm = new Alarm();
            anAlarm.Check();
            bool isAlarmOn = anAlarm.AlarmOn;
        }
    }
}
