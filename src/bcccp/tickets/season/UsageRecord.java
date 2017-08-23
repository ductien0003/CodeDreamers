package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {

	String ticketId;
	long startDateTime;
	long endDateTime;



	public UsageRecord(String ticketId, long startDateTime) {
		//TODO Implement constructor
		//added constructor
		this.ticketId = ticketId;
		this.startDateTime = startDateTime;
	}



	@Override
	public void finalise(long endDateTime) {
		// TODO Auto-generated method stub
		System.out.print("Time elapsed is "+startDateTime - endDateTime);

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
		return ticketId;
	}



}
