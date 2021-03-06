package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {
		//TODO Implement constructor
		this.exitGate=exitGate;
		ui.registerController(this);
		this.ui=ui;
		is.registerResponder(this);
		os.registerResponder(this);
		this.carpark=carpark;
		this.insideSensor=is;
		this.outsideSensor=os;
		
	}



	@Override
	public void ticketInserted(String ticketStr) {
		// TODO Auto-generated method stub
		if(!ticketStr.equals("") && insideSensor.carEventDetected()){
			if(ticketStr.contains("S")){
				seasonTicketId=ticketStr;
				if (carpark.isSeasonTicketInUse(seasonTicketId)&&carpark.isSeasonTicketValidated(seasonTicketId)){
					ui.display("take ticket");
					ticketValidated=true;
					ui.beep();
				}

			}
			else {
                    adhocTicket = carpark.getAdhocTicket(ticketStr);
                    if (adhocTicket != null) {
                        if (adhocTicket.isCurrent() && adhocTicket.isPaid() && (System.currentTimeMillis() - adhocTicket.getPaidDateTime() <= 900000)) { //900,000ms = 15 minutes
                            ui.display("take ticket");
                            ticketValidated = true;
                            ui.beep();
                        }
                        if (System.currentTimeMillis() - adhocTicket.getPaidDateTime() > 900000) {
                            ui.display("Please Wait For Attendant");
                        }
                    }
                
                }
                if (!ticketValidated) {
                    ui.display("Take Rejected Ticket");
                }
            }
            else {
                if (ticketStr.equals("")) {
                    ui.display("No Ticket Inserted");                
                }
                else {
                    ui.display("No Car Detected");
                }
                
            }
        }
			
				
			}
		}
		
	



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		if(ticketValidated){
			exitGate.raise();
			ticketValidated=false;
		}
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		if (detectorId.equals(insideSensor.getId()) && detected) {
                ui.display("Insert Ticket");
            }
        if (detectorId.equals(outsideSensor.getId()) && detected) {
                ui.display("Car Leaving");
            }
        if (detectorId.equals(insideSensor.getId()) && !detected) {
                ui.display("Car Left");
            }
        if (detectorId.equals(outsideSensor.getId()) && !detected) {
            exitGate.lower();
            ui.display("");
            exitTime = System.currentTimeMillis();
            if (adhocTicket != null) {
                adhocTicket.exit(exitTime);
                carpark.recordAdhocTicketExit();
                adhocTicket = null;
                }
            else {
                carpark.recordSeasonTicketExit(seasonTicketId);
                seasonTicketId = null;
                }
                
            }
		
	}
		
	}

	
	
}
