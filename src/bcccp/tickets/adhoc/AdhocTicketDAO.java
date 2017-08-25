package bcccp.tickets.adhoc;

import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	
	//Started coding and checking how to use guthub desktop
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
				//TODO Implement constructor
				this.factory = factory; //added constructor
	}


	//detection of car arrival
	@Override
	public IAdhocTicket createTicket(String carparkId) {
		// TODO Auto-generated method stub
		// setters and getters
		return this.carparkId;
	}


	//checks ticket validity
	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}


	// checking system ejecting the ticket
	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
