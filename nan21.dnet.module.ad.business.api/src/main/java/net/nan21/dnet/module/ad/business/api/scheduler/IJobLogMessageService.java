/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.scheduler;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLog;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLogMessage;

/**
 * Interface to expose business functions specific for {@link JobLogMessage} domain
 * entity.
 */
public interface IJobLogMessageService extends IEntityService<JobLogMessage> {

	/**
	 * Find by reference: jobLog
	 */
	public List<JobLogMessage> findByJobLog(JobLog jobLog);

	/**
	 * Find by ID of reference: jobLog.id
	 */
	public List<JobLogMessage> findByJobLogId(String jobLogId);
}
