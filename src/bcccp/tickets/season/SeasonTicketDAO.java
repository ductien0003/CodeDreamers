package bcccp.tickets.season;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;

public class SeasonTicketDAO implements ISeasonTicketDAO {

	private IUsageRecordFactory factory;




		//TOD Implement constructor  
=======
		

		

	
	
	public SeasonTicketDAO(IUsageRecordFactory factory) {
		//TOD Implement constructor  

	}



	@Override
	public void registerTicket(ISeasonTicket ticket) {
		// TODO Auto-generated method stub
		this.ticket = ticket;

	}



	@Override
	public void deregisterTicket(ISeasonTicket ticket) {
		// TODO Auto-generated method stub
		this.ticket = ticket;

	}



	@Override
	public int getNumberOfTickets() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ISeasonTicket findTicketById(String ticketId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void recordTicketEntry(String ticketId) {
		// TODO Auto-generated method stub

	}



	@Override
	public void recordTicketExit(String ticketId) {
		// TODO Auto-generated method stub

	}



}
