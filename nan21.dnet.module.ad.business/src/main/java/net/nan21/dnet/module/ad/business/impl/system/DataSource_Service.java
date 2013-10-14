/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IDataSourceService;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceRpc;

/**
 * Repository functionality for {@link DataSource} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DataSource_Service extends AbstractEntityService<DataSource>
		implements
			IDataSourceService {

	public DataSource_Service() {
		super();
	}

	public DataSource_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DataSource> getEntityClass() {
		return DataSource.class;
	}
	/**
	 * Find by unique key
	 */
	public DataSource findByName(String name) {
		return (DataSource) this.getEntityManager()
				.createNamedQuery(DataSource.NQ_FIND_BY_NAME)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DataSource findByModel(String model) {
		return (DataSource) this.getEntityManager()
				.createNamedQuery(DataSource.NQ_FIND_BY_MODEL)
				.setParameter("model", model).getSingleResult();
	}
	/**
	 * Find by reference: fields
	 */
	public List<DataSource> findByFields(DataSourceField fields) {
		return this.findByFieldsId(fields.getId());
	}
	/**
	 * Find by ID of reference: fields.id
	 */
	public List<DataSource> findByFieldsId(String fieldsId) {
		return (List<DataSource>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from DataSource e, IN (e.fields) c where  c.id = :fieldsId",
						DataSource.class).setParameter("fieldsId", fieldsId)
				.getResultList();
	}
	/**
	 * Find by reference: serviceMethods
	 */
	public List<DataSource> findByServiceMethods(DataSourceRpc serviceMethods) {
		return this.findByServiceMethodsId(serviceMethods.getId());
	}
	/**
	 * Find by ID of reference: serviceMethods.id
	 */
	public List<DataSource> findByServiceMethodsId(String serviceMethodsId) {
		return (List<DataSource>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from DataSource e, IN (e.serviceMethods) c where  c.id = :serviceMethodsId",
						DataSource.class)
				.setParameter("serviceMethodsId", serviceMethodsId)
				.getResultList();
	}
}
