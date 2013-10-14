/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceRpc;

/**
 * Interface to expose business functions specific for {@link DataSource} domain
 * entity.
 */
public interface IDataSourceService extends IEntityService<DataSource> {

	/**
	 * Find by unique key
	 */
	public DataSource findByName(String name);

	/**
	 * Find by unique key
	 */
	public DataSource findByModel(String model);

	/**
	 * Find by reference: fields
	 */
	public List<DataSource> findByFields(DataSourceField fields);

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<DataSource> findByFieldsId(String fieldsId);

	/**
	 * Find by reference: serviceMethods
	 */
	public List<DataSource> findByServiceMethods(DataSourceRpc serviceMethods);

	/**
	 * Find by ID of reference: serviceMethods.id
	 */
	public List<DataSource> findByServiceMethodsId(String serviceMethodsId);
}
