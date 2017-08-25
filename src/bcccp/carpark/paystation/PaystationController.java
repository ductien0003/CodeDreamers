package bcccp.carpark.paystation;

import bcccp.carpark.ICarpark;
import bcccp.tickets.adhoc.IAdhocTicket;

public class PaystationController 
		implements IPaystationController {
	
	private IPaystationUI ui;	
	private ICarpark carpark;

	private IAdhocTicket  adhocTicket = null;
	private float charge;
	
	

	public PaystationController(ICarpark carpark, IPaystationUI ui) {
		this.carpark=carpark;
		this.ui=ui;//TODO Implement constructor
	}



	@Override
	public void ticketInserted(String barcode) {
		if(!barcode)
			return 0;
		else
		{
		private Date date;
		private Date dateCompareOne;
private Date dateCompareTwo;

private String compareStringOne = "9:45";
private String compareStringTwo = "1:45";

SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US);

private void compareDates(){
    Calendar now = Calendar.getInstance();

    int hour = now.get(Calendar.HOUR);
    int minute = now.get(Calendar.MINUTE);

    date = parseDate(hour + ":" + minute);
    dateCompareOne = parseDate(compareStringOne);
    dateCompareTwo = parseDate(compareStringTwo);

    if ( dateCompareOne.before( date ) && dateCompareTwo.after(date)) {
        //    }
}

private Date parseDate(String date) {

    try {
        return inputParser.parse(date);
    } catch (java.text.ParseException e) {
        return new Date(0);
    }
}// TODO Auto-generated method stub
		
	}
	}


	@Override
	public void ticketPaid() {
		String ticketStr = barcodeTextField.getText();
		controller.ticketInserted(ticketStr);// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		controller.ticketTaken();
		ticketPrinterTextArea.setText("");
		barcodeTextField.setText("");// TODO Auto-generated method stub
		
	}

	
	
}
