package org.kirhgoff.mysha.server.services.gwt;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.PersistentRemoteService;

import org.kirhgoff.mysha.client.interfaces.InitialDataLoaderService;
import org.kirhgoff.mysha.server.interfaces.StartupService;
import org.kirhgoff.mysha.server.services.MyshaServerApplication;

public class InitialDataLoaderServiceImpl extends PersistentRemoteService implements InitialDataLoaderService {

	private static final long serialVersionUID = 8336011091333062487L;
	private StartupService startupService;

	public InitialDataLoaderServiceImpl() {
		setBeanManager((PersistentBeanManager) MyshaServerApplication.getInstance().getBean("beanManager"));
	}

	public String loadSampleData() {
		//TODO change nameed call to direct method call. move naming to the application
		if (startupService == null)
			startupService = (StartupService) MyshaServerApplication.getInstance().getBean(StartupService.NAME);
		
		if (startupService.isInitialized() == false) {
			startupService.initialize();
			return "Server initialized";
		} else {
			return "Server initialized ok";
		}
	}
}
