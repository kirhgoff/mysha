package org.kirhgoff.mysha.server;

import org.kirhgoff.mysha.client.services.ConfigurationRemote;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.PersistentRemoteService;


public class ConfigurationRemoteImpl extends PersistentRemoteService implements ConfigurationRemote {

	private static final long serialVersionUID = 8336011091333062487L;
	private IStartupService startupService;

	public ConfigurationRemoteImpl() {
		setBeanManager((PersistentBeanManager) ApplicationContext.getInstance().getBean("beanManager"));
		startupService = (IStartupService) ApplicationContext.getInstance().getBean(IStartupService.NAME);
	}

	public IStartupService getStartupService() {
		return startupService;
	}

	public void setStartupService(IStartupService service) {
		startupService = service;
	}


	public String initServerConfiguration() {
		if (startupService.isInitialized() == false) {
			startupService.initialize();
			return "Server initialized";
		} else {
			return "Server initialized ok";
		}
	}
}
