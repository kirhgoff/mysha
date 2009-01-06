package org.kirhgoff.mysha.server.interfaces;

public interface StartupService {

	public static final String NAME = "startupService";

	/**
	 * Indicates if the needed data has been initialized
	 */
	public boolean isInitialized();

	/**
	 * Initialize the underlying data
	 */
	public void initialize();

}