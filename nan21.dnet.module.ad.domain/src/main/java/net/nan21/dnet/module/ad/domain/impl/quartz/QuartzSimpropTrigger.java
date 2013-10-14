/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.quartz;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = QuartzSimpropTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzSimpropTrigger implements Serializable {

	public static final String TABLE_NAME = "QRTZ_SIMPROP_TRIGGERS";

	private static final long serialVersionUID = -8865917134914502125L;

	@Id
	@NotBlank
	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	private String schedulerName;

	@Id
	@NotBlank
	@Column(name = "TRIGGER_NAME", nullable = false, length = 255)
	private String triggerName;

	@Id
	@NotBlank
	@Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
	private String triggerGroup;

	@Column(name = "STR_PROP_1", length = 4000)
	private String strProp1;

	@Column(name = "STR_PROP_2", length = 4000)
	private String strProp2;

	@Column(name = "STR_PROP_3", length = 4000)
	private String strProp3;

	@Column(name = "INT_PROP_1", precision = 10)
	private Integer intProp1;

	@Column(name = "INT_PROP_2", precision = 10)
	private Integer intProp2;

	@Column(name = "LONG_PROP_1", precision = 13)
	private Long longProp1;

	@Column(name = "LONG_PROP_2", precision = 13)
	private Long longProp2;

	@Column(name = "DEC_PROP_1", precision = 19, scale = 6)
	private BigDecimal decProp1;

	@Column(name = "DEC_PROP_2", precision = 19, scale = 6)
	private BigDecimal decProp2;

	@Column(name = "BOOL_PROP_1", length = 1)
	private String boolProp1;

	@Column(name = "BOOL_PROP_2", length = 1)
	private String boolProp2;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return this.triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public String getStrProp1() {
		return this.strProp1;
	}

	public void setStrProp1(String strProp1) {
		this.strProp1 = strProp1;
	}

	public String getStrProp2() {
		return this.strProp2;
	}

	public void setStrProp2(String strProp2) {
		this.strProp2 = strProp2;
	}

	public String getStrProp3() {
		return this.strProp3;
	}

	public void setStrProp3(String strProp3) {
		this.strProp3 = strProp3;
	}

	public Integer getIntProp1() {
		return this.intProp1;
	}

	public void setIntProp1(Integer intProp1) {
		this.intProp1 = intProp1;
	}

	public Integer getIntProp2() {
		return this.intProp2;
	}

	public void setIntProp2(Integer intProp2) {
		this.intProp2 = intProp2;
	}

	public Long getLongProp1() {
		return this.longProp1;
	}

	public void setLongProp1(Long longProp1) {
		this.longProp1 = longProp1;
	}

	public Long getLongProp2() {
		return this.longProp2;
	}

	public void setLongProp2(Long longProp2) {
		this.longProp2 = longProp2;
	}

	public BigDecimal getDecProp1() {
		return this.decProp1;
	}

	public void setDecProp1(BigDecimal decProp1) {
		this.decProp1 = decProp1;
	}

	public BigDecimal getDecProp2() {
		return this.decProp2;
	}

	public void setDecProp2(BigDecimal decProp2) {
		this.decProp2 = decProp2;
	}

	public String getBoolProp1() {
		return this.boolProp1;
	}

	public void setBoolProp1(String boolProp1) {
		this.boolProp1 = boolProp1;
	}

	public String getBoolProp2() {
		return this.boolProp2;
	}

	public void setBoolProp2(String boolProp2) {
		this.boolProp2 = boolProp2;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	@PrePersist
	public void prePersist() {
	}
}
