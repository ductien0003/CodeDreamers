package bcccp.carpark;

import java.util.List;

import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;

public class Carpark implements ICarpark {
	
	private List<ICarparkObserver> observers;
	private String carparkId;
	private int capacity;
	private int numberOfCarsParked;
	private IAdhocTicketDAO adhocTicketDAO;
	private ISeasonTicketDAO seasonTicketDAO;
	
	
	
	public Carpark(String name, int capacity, 
			IAdhocTicketDAO adhocTicketDAO, 
			ISeasonTicketDAO seasonTicketDAO) {
		//TODO Implement constructor
				this.carparkId=name;
				this.capacity= capacity;
				this.adhocTicketDAO=adhocTicketDAO;
				this.seasonTicketDAO=seasonTicketDAO;
		
	}



	@Override
	public void register(ICarparkObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
		
	}



	@Override
	public void deregister(ICarparkObserver observer) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public String getName() {
		
		
	}



	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		Date date =new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek=calendar.get(Calendar.DAY-OFF-WEEK);
		if(dayOfWeek!=1 || dayOfWeek!=7){
			if(numberOfCarsParked>=capacity){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}



	@Override
	public IAdhocTicket issueAdhocTicket() {
		// TODO Auto-generated method stub
		
		return adhocTicketDAO.createTicket(carparkId);
	}



	@Override
	public void recordAdhocTicketEntry() {
		// TODO Auto-generated method stub
		numberOfCarsParked++; // increase the number of car by 1
		
	}



	@Override
	public IAdhocTicket getAdhocTicket(String barcode) {
		// TODO Auto-generated method stub
		if(adhocTicketDAO.findTicketByBarcode(barcode)!=null){
			return adhocTicketDAO.findTicketByBarcode(barcode);
		}
		else{
			return null;
		}
		
	}



	@Override
	public float calculateAddHocTicketCharge(long entryDateTime) {
		// TODO Auto-generated method stub
		float shortStayCharge=5;
		float longStayCharge=5000;
		if (System.currenTimeMillis()-entryDateTime<1000){
			System.out.println(System.currenTimeMillis()+"-"+entryDateTime+"="+(System.currenTimeMillis()-entryDateTime));
			System.out.println("long stay amount charged");
			return longStayCharge;
			
		}
		else{
			System.out.println(System.currenTimeMillis()+"-"+entryDateTime+"="+(System.currenTimeMillis()-entryDateTime));
			System.out.println("short stay amount charged");
			return shortStayCharge
		}
		
	}



	@Override
	public void recordAdhocTicketExit() {
		// TODO Auto-generated method stub
			numberOfCarsParked--;
		
	}



	@Override
	public void registerSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		this.seasonTicketDAO.registerTicket(seasonTicket);
	}



	@Override
	public void deregisterSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		this.seasonTicketDAO.deregisterTicket(seasonTicket);
	}



	@Override
	public boolean isSeasonTicketValid(String ticketId) {
		// TODO Auto-generated method stub
		
		ISeasonTicket sTicket=seasonTicketDAO.findTicketById(ticketId);
			if(sTicket!=null){
				return(sTicket.getEndValidPeriod()>System.currenTimeMillis() && sTicket.getStartValidPeriod()<=System.currenTimeMillis());
				
			}
			else{
				return false;
			}
	}



	@Override
	public boolean isSeasonTicketInUse(String ticketId) {
		// TODO Auto-generated method stub
		ISeasonTicket sTicket=seasonTicketDAO.findTicketById(ticketId);
		return sTicket.inUse();
	}



	@Override
	public void recordSeasonTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		seasonTicketDAO.recordTicketEntry(ticketId);
		
	}



	@Override
	public void recordSeasonTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		seasonTicketDAO.recordTicketExit(ticketId);
		
	}

	
	

}
