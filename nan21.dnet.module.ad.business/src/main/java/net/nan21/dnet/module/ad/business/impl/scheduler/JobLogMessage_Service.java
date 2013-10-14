/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.scheduler;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobLogMessageService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLog;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLogMessage;

/**
 * Repository functionality for {@link JobLogMessage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobLogMessage_Service extends AbstractEntityService<JobLogMessage>
		implements
			IJobLogMessageService {

	public JobLogMessage_Service() {
		super();
	}

	public JobLogMessage_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobLogMessage> getEntityClass() {
		return JobLogMessage.class;
	}
	/**
	 * Find by reference: jobLog
	 */
	public List<JobLogMessage> findByJobLog(JobLog jobLog) {
		return this.findByJobLogId(jobLog.getId());
	}
	/**
	 * Find by ID of reference: jobLog.id
	 */
	public List<JobLogMessage> findByJobLogId(String jobLogId) {
		return (List<JobLogMessage>) this
				.getEntityManager()
				.createQuery(
						"select e from JobLogMessage e where e.clientId = :clientId and e.jobLog.id = :jobLogId",
						JobLogMessage.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobLogId", jobLogId).getResultList();
	}
}
