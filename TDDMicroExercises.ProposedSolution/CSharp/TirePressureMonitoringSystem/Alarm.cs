namespace TDDMicroExercises.OneSolution.TirePressureMonitoringSystem
{
    public class Alarm
    {
        public const double LowPressureTreshold = 17;
        public const double HighPressureTreshold = 21;

        readonly ISensor _sensor;

        bool _alarmOn = false;

        public Alarm() : this(new Sensor())
        {
        }

        public Alarm(ISensor sensor)
        {
            _sensor = sensor;
        }

        public void Check()
        {
            double psiPressureValue = _sensor.PopNextPressurePsiValue();

            if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
            {
                _alarmOn = true;
            }
        }

        public bool AlarmOn
        {
            get { return _alarmOn; }
        }

    }
}
