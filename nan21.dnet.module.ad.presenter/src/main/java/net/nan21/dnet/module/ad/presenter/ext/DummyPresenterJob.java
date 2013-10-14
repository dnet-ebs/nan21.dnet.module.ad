package net.nan21.dnet.module.ad.presenter.ext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nan21.dnet.core.api.annotation.JobParam;
import net.nan21.dnet.core.presenter.service.job.AbstractPresenterJob;
import net.nan21.dnet.module.ad.domain.impl.security.Role;

public class DummyPresenterJob extends AbstractPresenterJob {

	final static Logger logger = LoggerFactory
			.getLogger(DummyPresenterJob.class);

	@JobParam
	private String stringParam;

	@JobParam
	private int intParam;

	@JobParam
	private Integer integerParam;

	@JobParam
	private long longParam;

	@JobParam
	private Long pLongParam;

	@JobParam
	private boolean booleanParam;

	@JobParam
	private Boolean pBooleanParam;

	@JobParam
	private Date dateParam;

	@Override
	protected void onExecute() throws Exception {

		logger.info("======================= DummyPresenterJob.onExecute ================================");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "ROLE_DNET_USER");

		String s = this.findEntityService(Role.class)
				.findByUk(Role.NQ_FIND_BY_CODE, params).getName();
		logger.info(s);

		this.getPersistableLog().info(
				"This is an `info` message. Executing DummyPresenterJob.");
		this.getPersistableLog().warning(
				"This is a `warning` message. First role found is " + s + ". ");
	}

	public String getStringParam() {
		return stringParam;
	}

	public void setStringParam(String stringParam) {
		this.stringParam = stringParam;
	}

	public int getIntParam() {
		return intParam;
	}

	public void setIntParam(int intParam) {
		this.intParam = intParam;
	}

	public Integer getIntegerParam() {
		return integerParam;
	}

	public void setIntegerParam(Integer integerParam) {
		this.integerParam = integerParam;
	}

	public long getLongParam() {
		return longParam;
	}

	public void setLongParam(long longParam) {
		this.longParam = longParam;
	}

	public Long getpLongParam() {
		return pLongParam;
	}

	public void setpLongParam(Long pLongParam) {
		this.pLongParam = pLongParam;
	}

	public boolean isBooleanParam() {
		return booleanParam;
	}

	public void setBooleanParam(boolean booleanParam) {
		this.booleanParam = booleanParam;
	}

	public Boolean getpBooleanParam() {
		return pBooleanParam;
	}

	public void setpBooleanParam(Boolean pBooleanParam) {
		this.pBooleanParam = pBooleanParam;
	}

	public Date getDateParam() {
		return dateParam;
	}

	public void setDateParam(Date dateParam) {
		this.dateParam = dateParam;
	}

}