/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;
import java.util.Date;
import net.nan21.dnet.module.ad.presenter.impl.scheduler.model.JobTimer_Ds;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class JobTimer_DsFilter extends JobTimer_Ds {

	private Date startTime_From;

	private Date startTime_To;

	private Date endTime_From;

	private Date endTime_To;

	public Date getStartTime_From() {
		return this.startTime_From;
	}

	public Date getStartTime_To() {
		return this.startTime_To;
	}

	public void setStartTime_From(Date startTime_From) {
		this.startTime_From = startTime_From;
	}

	public void setStartTime_To(Date startTime_To) {
		this.startTime_To = startTime_To;
	}

	public Date getEndTime_From() {
		return this.endTime_From;
	}

	public Date getEndTime_To() {
		return this.endTime_To;
	}

	public void setEndTime_From(Date endTime_From) {
		this.endTime_From = endTime_From;
	}

	public void setEndTime_To(Date endTime_To) {
		this.endTime_To = endTime_To;
	}
}
