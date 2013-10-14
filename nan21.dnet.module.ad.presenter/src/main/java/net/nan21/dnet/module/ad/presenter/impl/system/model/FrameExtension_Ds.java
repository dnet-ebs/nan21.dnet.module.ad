/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.ad.domain.impl.system.FrameExtension;

@Ds(entity = FrameExtension.class)
public class FrameExtension_Ds extends AbstractAuditableDs<FrameExtension> {

	public static final String f_frame = "frame";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_fileLocation = "fileLocation";
	public static final String f_relativePath = "relativePath";

	@DsField
	private String frame;

	@DsField
	private Integer sequenceNo;

	@DsField
	private String fileLocation;

	@DsField
	private Boolean relativePath;

	public FrameExtension_Ds() {
		super();
	}

	public FrameExtension_Ds(FrameExtension e) {
		super(e);
	}

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
}
