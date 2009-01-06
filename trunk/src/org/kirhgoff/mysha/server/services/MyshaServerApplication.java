package org.kirhgoff.mysha.server.services;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class MyshaServerApplication {
	private static final String CONTEXT_FILE = "org/kirhgoff/mysha/applicationContext.xml";
	private static MyshaServerApplication INSTANCE;
	protected GenericApplicationContext springContext;

	public static synchronized final MyshaServerApplication getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MyshaServerApplication();
		}
		return INSTANCE;
	}

	protected MyshaServerApplication() {
		initContextFile();
	}

	public Object getBean(String beanName) {
		return springContext.getBean(beanName);
	}

	private void initContextFile() {
		springContext = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(springContext);
		xmlReader.loadBeanDefinitions(new ClassPathResource(CONTEXT_FILE));
		springContext.refresh();
	}
}
