/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;
import java.util.Date;
import net.nan21.dnet.module.ad.presenter.impl.system.model.DbChangeLog_Ds;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class DbChangeLog_DsFilter extends DbChangeLog_Ds {

	private Date dateExecuted_From;

	private Date dateExecuted_To;

	private Integer orderExecuted_From;

	private Integer orderExecuted_To;

	public Date getDateExecuted_From() {
		return this.dateExecuted_From;
	}

	public Date getDateExecuted_To() {
		return this.dateExecuted_To;
	}

	public void setDateExecuted_From(Date dateExecuted_From) {
		this.dateExecuted_From = dateExecuted_From;
	}

	public void setDateExecuted_To(Date dateExecuted_To) {
		this.dateExecuted_To = dateExecuted_To;
	}

	public Integer getOrderExecuted_From() {
		return this.orderExecuted_From;
	}

	public Integer getOrderExecuted_To() {
		return this.orderExecuted_To;
	}

	public void setOrderExecuted_From(Integer orderExecuted_From) {
		this.orderExecuted_From = orderExecuted_From;
	}

	public void setOrderExecuted_To(Integer orderExecuted_To) {
		this.orderExecuted_To = orderExecuted_To;
	}
}
