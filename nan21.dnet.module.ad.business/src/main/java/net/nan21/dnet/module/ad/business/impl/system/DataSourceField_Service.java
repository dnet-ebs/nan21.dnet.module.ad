/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IDataSourceFieldService;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;

/**
 * Repository functionality for {@link DataSourceField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DataSourceField_Service
		extends
			AbstractEntityService<DataSourceField>
		implements
			IDataSourceFieldService {

	public DataSourceField_Service() {
		super();
	}

	public DataSourceField_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DataSourceField> getEntityClass() {
		return DataSourceField.class;
	}
	/**
	 * Find by unique key
	 */
	public DataSourceField findByName(DataSource dataSource, String name) {
		return (DataSourceField) this.getEntityManager()
				.createNamedQuery(DataSourceField.NQ_FIND_BY_NAME)
				.setParameter("dataSource", dataSource)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DataSourceField findByName(Long dataSourceId, String name) {
		return (DataSourceField) this.getEntityManager()
				.createNamedQuery(DataSourceField.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("dataSourceId", dataSourceId)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: dataSource
	 */
	public List<DataSourceField> findByDataSource(DataSource dataSource) {
		return this.findByDataSourceId(dataSource.getId());
	}
	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<DataSourceField> findByDataSourceId(String dataSourceId) {
		return (List<DataSourceField>) this
				.getEntityManager()
				.createQuery(
						"select e from DataSourceField e where  e.dataSource.id = :dataSourceId",
						DataSourceField.class)
				.setParameter("dataSourceId", dataSourceId).getResultList();
	}
}
