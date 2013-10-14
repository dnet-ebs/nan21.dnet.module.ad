package net.nan21.dnet.module.ad.presenter.ext;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.nan21.dnet.core.api.extensions.IExtensionFile;
import net.nan21.dnet.core.api.extensions.IExtensionProvider;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.extensions.ExtensionFile;
import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.ad.domain.impl.system.FrameExtension;

/**
 * Return extension files defined in database for the given target
 * 
 * @author amathe
 * 
 */
public class ExtensionProviderScriptFromDb extends AbstractPresenterBaseService
		implements IExtensionProvider {

	@Override
	public List<IExtensionFile> getFiles(String targetFrame) throws Exception {

		List<IExtensionFile> files = new ArrayList<IExtensionFile>();

		try {
			DataSource dataSource = this.getApplicationContext().getBean(
					DataSource.class);
			JdbcTemplate tpl = new JdbcTemplate(dataSource);
			tpl.queryForList("select 1 from " + FrameExtension.TABLE_NAME
					+ "  where 1=0");

		} catch (Exception e) {
			return files;
		}

		List<FrameExtension> result = this
				.findEntityService(FrameExtension.class)
				.getEntityManager()
				.createQuery(
						" select e from "
								+ FrameExtension.class.getSimpleName()
								+ " e where "
								+ " e.clientId = :clientId and e.frame = :frame and e.active = true",
						FrameExtension.class)
				.setParameter("frame", targetFrame)
				.setParameter("clientId", Session.user.get().getClientId())
				.getResultList();

		for (FrameExtension e : result) {
			files.add(new ExtensionFile(e.getFileLocation(), e
					.getRelativePath()));
		}
		return files;
	}

}
