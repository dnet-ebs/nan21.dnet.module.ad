package net.nan21.dnet.module.ad.presenter.ext.scheduler.delegate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobContextService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;
import net.nan21.dnet.module.ad.presenter.impl.scheduler.model.JobContext_Ds;

public class JobContext_Pd extends AbstractPresenterDelegate {

	final static Logger logger = LoggerFactory.getLogger(JobContext_Pd.class);

	public void synchronizeParameters(List<JobContext_Ds> list)
			throws Exception {

		List<Object> ids = this.collectIds(list);

		IJobContextService srv = (IJobContextService) this
				.findEntityService(JobContext.class);
		EntityManager em = srv.getEntityManager();

		// delete the obsolete job-context parameters

		// make the delete in two steps, Eclipselink builds a sh*t of delete
		// statement otherwise

		List<String> idsToDelete = em
				.createQuery(
						" select e.id from "
								+ JobContextParam.class.getSimpleName()
								+ " e  where e.clientId = :clientId "
								+ "		and e.jobContext.id in :ids"
								+ "     and not exists ( "
								+ "			select 1 from JobParam p "
								+ "			where p.name = e.paramName "
								+ "			  and p.job.name =  e.jobContext.jobName)"
								+ "   ", String.class)
				.setParameter("clientId", Session.user.get().getClientId())
				.setParameter("ids", ids).getResultList();

		if (idsToDelete.size() > 0) {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("pIds", idsToDelete);

			int x = srv.update(
					"delete from JobContextParam  where id in :pIds",
					parameters);

			if (logger.isDebugEnabled()) {
				logger.debug("Deleted " + x
						+ " obsolete job-context parameters. ");
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("No obsolete job-context parameters to delete. ");
			}
		}

		// create the missing ones

		List<JobContext> jobContexts = srv.findByIds(ids);
		for (JobContext jc : jobContexts) {
			List<JobParam> paramsToCreate = em
					.createQuery(
							"select p from " + JobParam.class.getSimpleName()
									+ " p where p.job.name = :jobName"
									+ "     and p.name not in ("
									+ " select x.paramName "
									+ "   from JobContextParam x "
									+ "  where x.clientId = :clientId"
									+ "    and x.jobContext.id = :id ) ",
							JobParam.class)
					.setParameter("clientId", Session.user.get().getClientId())
					.setParameter("id", jc.getId())
					.setParameter("jobName", jc.getJobName()).getResultList();

			for (JobParam jp : paramsToCreate) {
				if (logger.isDebugEnabled()) {
					logger.debug(
							"Creating job-context parameters: job={} paramName={}.",
							new String[] { jc.getJobName(), jp.getName() });
				}
				JobContextParam cp = new JobContextParam();
				cp.setJobContext(jc);
				cp.setParamName(jp.getName());
				cp.setDataType(jp.getDataType());
				jc.addToParams(cp);
			}

		}
		srv.update(jobContexts);
	}
}
