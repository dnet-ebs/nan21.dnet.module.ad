/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IJobParamService;
import net.nan21.dnet.module.ad.domain.impl.system.Job;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;

/**
 * Repository functionality for {@link JobParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobParam_Service extends AbstractEntityService<JobParam>
		implements
			IJobParamService {

	public JobParam_Service() {
		super();
	}

	public JobParam_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobParam> getEntityClass() {
		return JobParam.class;
	}
	/**
	 * Find by unique key
	 */
	public JobParam findByName(Job job, String name) {
		return (JobParam) this.getEntityManager()
				.createNamedQuery(JobParam.NQ_FIND_BY_NAME)
				.setParameter("job", job).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public JobParam findByName(Long jobId, String name) {
		return (JobParam) this.getEntityManager()
				.createNamedQuery(JobParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("jobId", jobId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: job
	 */
	public List<JobParam> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}
	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobParam> findByJobId(String jobId) {
		return (List<JobParam>) this
				.getEntityManager()
				.createQuery(
						"select e from JobParam e where  e.job.id = :jobId",
						JobParam.class).setParameter("jobId", jobId)
				.getResultList();
	}
}
