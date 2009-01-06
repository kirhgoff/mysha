package org.kirhgoff.mysha.server;

public interface IStartupService {

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