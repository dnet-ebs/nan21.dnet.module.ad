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
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;

/**
 * Repository functionality for {@link JobContextParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobContextParam_Service
		extends
			AbstractEntityService<JobContextParam> {

	public JobContextParam_Service() {
		super();
	}

	public JobContextParam_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobContextParam> getEntityClass() {
		return JobContextParam.class;
	}
	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(JobContext jobContext, String paramName) {
		return (JobContextParam) this
				.getEntityManager()
				.createNamedQuery(JobContextParam.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContext", jobContext)
				.setParameter("paramName", paramName).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(Long jobContextId, String paramName) {
		return (JobContextParam) this
				.getEntityManager()
				.createNamedQuery(JobContextParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContextId", jobContextId)
				.setParameter("paramName", paramName).getSingleResult();
	}
	/**
	 * Find by reference: jobContext
	 */
	public List<JobContextParam> findByJobContext(JobContext jobContext) {
		return this.findByJobContextId(jobContext.getId());
	}
	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobContextParam> findByJobContextId(String jobContextId) {
		return (List<JobContextParam>) this
				.getEntityManager()
				.createQuery(
						"select e from JobContextParam e where e.clientId = :clientId and e.jobContext.id = :jobContextId",
						JobContextParam.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("jobContextId", jobContextId).getResultList();
	}
}
