package org.kirhgoff.mysha.server;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Global application context
 * @author bruno.marchesson
 */
public class ApplicationContext {
	private static final String CONTEXT_FILE = "org/kirhgoff/mysha/resources/applicationContext.xml";
	private static ApplicationContext INSTANCE;
	protected GenericApplicationContext springContext;

	public static synchronized final ApplicationContext getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationContext();
		}
		return INSTANCE;
	}

	protected ApplicationContext() {
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
