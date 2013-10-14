/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Client level extensions to customize the Extjs user interface.
 */
@NamedQueries({@NamedQuery(name = FrameExtension.NQ_FIND_BY_NAME, query = "SELECT e FROM FrameExtension e WHERE e.clientId = :clientId and e.frame = :frame and e.fileLocation = :fileLocation", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FrameExtension.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FrameExtension.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "FRAME", "FILELOCATION"})})
public class FrameExtension extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_FRAME_EXT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "FrameExtension.findByName";

	@NotBlank
	@Column(name = "FRAME", nullable = false, length = 255)
	private String frame;

	@NotNull
	@Column(name = "SEQUENCENO", nullable = false, precision = 4)
	private Integer sequenceNo;

	@NotBlank
	@Column(name = "FILELOCATION", nullable = false, length = 255)
	private String fileLocation;

	@NotNull
	@Column(name = "RELATIVEPATH", nullable = false)
	private Boolean relativePath;

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Boolean getRelativePath() {
		return this.relativePath;
	}

	public void setRelativePath(Boolean relativePath) {
		this.relativePath = relativePath;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.relativePath == null) {
			this.relativePath = new Boolean(false);
		}
	}
}
