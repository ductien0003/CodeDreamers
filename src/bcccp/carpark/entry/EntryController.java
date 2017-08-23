package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		//TODO Implement constructor
		this.entryGate=entryGate;
		os.registerResponder(this);
		is.registerResponder(this);
		outsideSensor=os;
		this.carpark=carpark;
		ui.registerController(this);
		this.ui=ui;
	}



	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
		if(!outsideSensor.carIsDetected()){
			ui.display("No car detected");
		}
		else{
			if(!carpark.isFull()){
				System.out.println("car park is not full");
				if(!ui.ticketPrinted()){
					adhocTicket=carpark.issueAdhocTicke();
					entryType="adhoc";
					adhocTicket.enter(entryTime);
					ui.printTicket(carpark.getName(),adhocTicket.getTicketNo(),adhocTicket.getEntryDateTime(),adhocTicket.getBarcode());
					ui.display("Take Ticket");
				}
			else{
					System.out.println("Ticket already printed, please take your ticket.");
					ui.display("Ticket already printed");
			}
			}
			else{
				while(carpark.isFull() && outsideSensor.carIsDetected())
                ui.display("Full")
			}
		}
	}



	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		if(!outsideSensor.carIsDetected()){
                ui.display("No car detected");
            }
            else{
                if(barcode != null){
                    if(carpark.isSeasonTicketValid(barcode)){
                        if(carpark.isSeasonTicketInUse(barcode)){
                            System.out.println("Season ticket valid");
                            entryType = "season";
                            ui.display("Take Ticket");
                        }
                        else{
                            System.out.println("Season ticket is in use");
                            ui.display("ticket in use");
                        }
                    }
                    else{
                        System.out.println("Season ticket not valid");
                        ui.display("Ticket Rejected");
                    }
                }
                else{
                    System.out.println("Season ticket button press, no season ticket entered");
                    ui.display("");
                }
                    
                    


            }
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		 if(entryType != null && (entryType.contentEquals("adhoc") || entryType.contentEquals("season"))){
                ui.display("Thank you");
                entryGate.raise(); 
                if(entryType.contentEquals("adhoc")){
                    carpark.recordAdhocTicketEntry();
                    System.out.println(adhocTicket.getBarcode());
                }
                if(entryType.contentEquals("season")){
                    carpark.recordSeasonTicketEntry(seasonTicketId);
                    
                }
                entryType = "";
	}



	@Override
	public void notifyCarparkEvent() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
