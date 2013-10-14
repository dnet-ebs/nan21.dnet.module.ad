/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.Job;

@Ds(entity = Job.class, sort = {@SortField(field = Job_Ds.f_name)})
public class Job_Ds extends AbstractTypeNTDs<Job> {

	public static final String f_javaClass = "javaClass";

	@DsField
	private String javaClass;

	public Job_Ds() {
		super();
	}

	public Job_Ds(Job e) {
		super(e);
	}

	public String getJavaClass() {
		return this.javaClass;
	}

	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}
}
