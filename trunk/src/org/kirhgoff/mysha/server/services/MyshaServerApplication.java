package org.kirhgoff.mysha.server.services;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class MyshaServerApplication {
	private static final String CONTEXT_FILE = "org/kirhgoff/mysha/applicationContext.xml";
	private static MyshaServerApplication instance;
	protected GenericApplicationContext springContext;

	public static synchronized final MyshaServerApplication getInstance() {
		if (instance == null) {
			instance = new MyshaServerApplication();
		}
		return instance;
	}

	protected MyshaServerApplication() {
		springContext = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(springContext);
		xmlReader.loadBeanDefinitions(new ClassPathResource(CONTEXT_FILE));
		springContext.refresh();
	}

	//TODO take care about this ambiguity bean=service
	public Object getBean(String beanName) {
		return springContext.getBean(beanName);
	}
}
