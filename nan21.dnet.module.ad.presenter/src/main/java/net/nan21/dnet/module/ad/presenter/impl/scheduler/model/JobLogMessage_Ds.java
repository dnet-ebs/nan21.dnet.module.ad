/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLogMessage;

@Ds(entity = JobLogMessage.class)
public class JobLogMessage_Ds extends AbstractAuditableDs<JobLogMessage> {

	public static final String f_messageType = "messageType";
	public static final String f_message = "message";
	public static final String f_jobLogId = "jobLogId";

	@DsField
	private String messageType;

	@DsField
	private String message;

	@DsField(join = "left", path = "jobLog.id")
	private String jobLogId;

	public JobLogMessage_Ds() {
		super();
	}

	public JobLogMessage_Ds(JobLogMessage e) {
		super(e);
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJobLogId() {
		return this.jobLogId;
	}

	public void setJobLogId(String jobLogId) {
		this.jobLogId = jobLogId;
	}
}
