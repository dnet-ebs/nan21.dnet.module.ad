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
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

/**
 * Repository functionality for {@link JobTimer} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobTimer_Service extends AbstractEntityService<JobTimer> {

	public JobTimer_Service() {
		super();
	}

	public JobTimer_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobTimer> getEntityClass() {
		return JobTimer.class;
	}
	/**
	 * Find by unique key
	 */
	public JobTimer findByName(JobContext jobContext, String name) {
		return (JobTimer) this
				.getEntityManager()
				.createNamedQuery(JobTimer.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContext", jobContext)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public JobTimer findByName(Long jobContextId, String name) {
		return (JobTimer) this
				.getEntityManager()
				.createNamedQuery(JobTimer.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContextId", jobContextId)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: jobContext
	 */
	public List<JobTimer> findByJobContext(JobContext jobContext) {
		return this.findByJobContextId(jobContext.getId());
	}
	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobTimer> findByJobContextId(String jobContextId) {
		return (List<JobTimer>) this
				.getEntityManager()
				.createQuery(
						"select e from JobTimer e where e.clientId = :clientId and e.jobContext.id = :jobContextId",
						JobTimer.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContextId", jobContextId).getResultList();
	}
}
