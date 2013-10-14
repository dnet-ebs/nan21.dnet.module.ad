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

/**
 * Interface to expose business functions specific for {@link DataSourceField} domain
 * entity.
 */
public interface IDataSourceFieldService
		extends
			IEntityService<DataSourceField> {

	/**
	 * Find by unique key
	 */
	public DataSourceField findByName(DataSource dataSource, String name);

	/**
	 * Find by unique key
	 */
	public DataSourceField findByName(Long dataSourceId, String name);

	/**
	 * Find by reference: dataSource
	 */
	public List<DataSourceField> findByDataSource(DataSource dataSource);

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<DataSourceField> findByDataSourceId(String dataSourceId);
}
