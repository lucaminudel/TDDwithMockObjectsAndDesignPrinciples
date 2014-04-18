namespace TDDMicroExercises.TurnTicketDispenser
{
    public class TurnNumberSequence
    {
        private static int _turnNumber = 0;

        public virtual int GetNextTurnNumber()
        {
            return _turnNumber++;
        }
    }
}
