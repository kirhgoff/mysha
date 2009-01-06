package org.kirhgoff.mysha.server;

/**
 * Service used to initialize the underlying data for demo application
 * @author bruno.marchesson
 *
 */
public class StartupService implements IStartupService
{
	public boolean isInitialized()
	{
		return true;
	}
	
	public void initialize()
	{
		System.out.println("Initialized");

	}
}
