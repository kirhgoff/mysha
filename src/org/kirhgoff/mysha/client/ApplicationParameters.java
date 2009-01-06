package org.kirhgoff.mysha.client;

public class ApplicationParameters {

	private static ApplicationParameters INSTANCE = null;
	private MyshaApplication application;

	protected ApplicationParameters() {}
	
	public static ApplicationParameters getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationParameters();
		}
		return INSTANCE;
	}

	public MyshaApplication getApplication() {
		return application;
	}


	public void setApplication(MyshaApplication application) {
		this.application = application;
	}
}
