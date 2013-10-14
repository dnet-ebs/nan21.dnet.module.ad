/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IDataSourceRpcService;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceRpc;

/**
 * Repository functionality for {@link DataSourceRpc} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DataSourceRpc_Service extends AbstractEntityService<DataSourceRpc>
		implements
			IDataSourceRpcService {

	public DataSourceRpc_Service() {
		super();
	}

	public DataSourceRpc_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DataSourceRpc> getEntityClass() {
		return DataSourceRpc.class;
	}
	/**
	 * Find by unique key
	 */
	public DataSourceRpc findByName(DataSource dataSource, String name) {
		return (DataSourceRpc) this.getEntityManager()
				.createNamedQuery(DataSourceRpc.NQ_FIND_BY_NAME)
				.setParameter("dataSource", dataSource)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DataSourceRpc findByName(Long dataSourceId, String name) {
		return (DataSourceRpc) this.getEntityManager()
				.createNamedQuery(DataSourceRpc.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("dataSourceId", dataSourceId)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: dataSource
	 */
	public List<DataSourceRpc> findByDataSource(DataSource dataSource) {
		return this.findByDataSourceId(dataSource.getId());
	}
	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<DataSourceRpc> findByDataSourceId(String dataSourceId) {
		return (List<DataSourceRpc>) this
				.getEntityManager()
				.createQuery(
						"select e from DataSourceRpc e where  e.dataSource.id = :dataSourceId",
						DataSourceRpc.class)
				.setParameter("dataSourceId", dataSourceId).getResultList();
	}
}
