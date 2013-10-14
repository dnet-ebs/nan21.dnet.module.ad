package net.nan21.dnet.module.ad.business.ext.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.exceptions.InvalidDatabase;
import net.nan21.dnet.core.api.service.ISysParamValueProvider;
import net.nan21.dnet.core.business.service.AbstractBusinessBaseService;
import net.nan21.dnet.module.ad.domain.impl.system.ParamValue;

public class ParamValueProvider extends AbstractBusinessBaseService implements
		ISysParamValueProvider {

	/**
	 * Return parameter vales for current client valid at the specified date.
	 */
	@Override
	public Map<String, String> getParamValues(Date validAt)
			throws BusinessException, InvalidDatabase {

		try {
			DataSource dataSource = this.getApplicationContext().getBean(
					DataSource.class);
			JdbcTemplate tpl = new JdbcTemplate(dataSource);
			tpl.queryForList("select 1 from " + ParamValue.TABLE_NAME
					+ "  where 1=0");

		} catch (Exception e) {
			throw new InvalidDatabase(e.getMessage());
		}

		Date _validAt = validAt;
		if (_validAt == null) {
			_validAt = new Date();
		}

		List<ParamValue> values = this
				.getEntityManager()
				.createQuery(
						"select e from "
								+ ParamValue.class.getSimpleName()
								+ " e where :validAt between e.validFrom and e.validTo order by e.validFrom",
						ParamValue.class).setParameter("validAt", _validAt)
				.getResultList();
		Map<String, String> result = new HashMap<String, String>();
		for (ParamValue v : values) {
			result.put(v.getSysParam(), v.getValue());
		}
		return result;
	}
}
