package bcccp.tickets.season;

public class UsageRecordFactory implements IUsageRecordFactory {

	@Override
	public IUsageRecord make(String ticketId, long startDateTime) {
		// TODO Auto-generated method stub
		System.out.print("Ticket ID " +ticketId+" is starting at "+startDateTime);
		return null;
	}


}
