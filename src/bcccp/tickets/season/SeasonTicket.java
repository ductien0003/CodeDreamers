package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonTicket implements ISeasonTicket {

	private List<IUsageRecord> usages;
	private IUsageRecord currentUsage = null;

	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;

	public SeasonTicket (String ticketId,
			             String carparkId,
			             long startValidPeriod,
			             long endValidPeriod) {
		//TDO Imp
		this.ticketId = ticketId;
		this.carparkId = carparkId;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return ticketId;
	}

	@Override
	public String getCarparkId() {
		// TODO Auto-generated method stub
		return carparkId;
	}

	@Override
	public long getStartValidPeriod() {
		// TODO Auto-generated method stub
		return startValidPeriod;
	}

	@Override
	public long getendValidPeriod() {
		// TODO Auto-generated method stub
		return endValidPeriod;
	}

	@Override
	public boolean inUse() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void recordUsage(IUsageRecord record) {
		// TODO Auto-generated method stub
		record = startDateTime - endDateTime;


	}

	@Override
	public IUsageRecord getCurrentUsageRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endUsage(long dateTime) {


	}

	@Override
	public List<IUsageRecord> getUsageRecords() {
		// TODO Auto-generated method stub
		return null;
	}


}
