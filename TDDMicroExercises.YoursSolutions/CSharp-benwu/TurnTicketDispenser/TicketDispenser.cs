namespace TDDMicroExercises.TurnTicketDispenser
{
    public class TicketDispenser
    {
        public virtual TurnTicket GetTurnTicket()
        {
            TurnNumberSequence turnNumberSequence = new TurnNumberSequence();
            int newTurnNumber = turnNumberSequence.GetNextTurnNumber();
            var newTurnTicket = new TurnTicket(newTurnNumber);

            return newTurnTicket;
        }
    }
}
