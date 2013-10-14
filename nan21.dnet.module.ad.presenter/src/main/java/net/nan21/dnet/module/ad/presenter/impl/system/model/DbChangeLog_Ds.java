/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;
import net.nan21.dnet.module.ad.domain.impl.system.DbChangeLog;

@Ds(entity = DbChangeLog.class, sort = {@SortField(field = DbChangeLog_Ds.f_orderExecuted, desc = true)})
public class DbChangeLog_Ds extends AbstractDsModel<DbChangeLog>
		implements
			IModelWithId {

	public static final String f_id = "id";
	public static final String f_txid = "txid";
	public static final String f_author = "author";
	public static final String f_filename = "filename";
	public static final String f_dateExecuted = "dateExecuted";
	public static final String f_orderExecuted = "orderExecuted";
	public static final String f_md5sum = "md5sum";
	public static final String f_description = "description";
	public static final String f_comments = "comments";
	public static final String f_tag = "tag";
	public static final String f_liquibase = "liquibase";

	@DsField(fetch = false)
	private String id;

	@DsField
	private String txid;

	@DsField
	private String author;

	@DsField
	private String filename;

	@DsField
	private Date dateExecuted;

	@DsField
	private Integer orderExecuted;

	@DsField
	private String md5sum;

	@DsField
	private String description;

	@DsField
	private String comments;

	@DsField
	private String tag;

	@DsField
	private String liquibase;

	public DbChangeLog_Ds() {
		super();
	}

	public DbChangeLog_Ds(DbChangeLog e) {
		super(e);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxid() {
		return this.txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getDateExecuted() {
		return this.dateExecuted;
	}

	public void setDateExecuted(Date dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public Integer getOrderExecuted() {
		return this.orderExecuted;
	}

	public void setOrderExecuted(Integer orderExecuted) {
		this.orderExecuted = orderExecuted;
	}

	public String getMd5sum() {
		return this.md5sum;
	}

	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLiquibase() {
		return this.liquibase;
	}

	public void setLiquibase(String liquibase) {
		this.liquibase = liquibase;
	}
}
