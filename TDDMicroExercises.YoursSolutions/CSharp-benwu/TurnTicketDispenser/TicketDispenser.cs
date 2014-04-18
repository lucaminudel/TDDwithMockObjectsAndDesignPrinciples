namespace TDDMicroExercises.TurnTicketDispenser
{
    public class TicketDispenser
    {
        public virtual TurnTicket GetTurnTicket()
        {
            int newTurnNumber = TurnNumberSequence.GetNextTurnNumber();
            var newTurnTicket = new TurnTicket(newTurnNumber);

            return newTurnTicket;
        }
    }
}
