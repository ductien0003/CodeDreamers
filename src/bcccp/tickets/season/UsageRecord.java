package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {

	String ticketId;
	long startDateTime;
	long endDateTime;



	public UsageRecord(String ticketId, long startDateTime) {
		//TODO Implement constructor

		this.ticketId = ticketId;
		this.startDateTime = StartDateTime;

	}



	@Override
	public long finalise(long endDateTime) {
		return startDateTime - endDateTime;

	}



	@Override
	public long getStartTime() {
		// TODO Auto-generated method stub
		return startDateTime;
	}



	@Override
	public long getEndTime() {
		// TODO Auto-generated method stub
		return endDateTime;
	}



	@Override
	public String getSeasonTicketId() {
		// TODO Auto-generated method stub
		return null;
	}



}
