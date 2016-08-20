package framework;

public interface Input {

	/**
	 * Add input parameter to Input
	 * 
	 * @param name
	 * @param value
	 */
	public void addParameter(String name, String value);
	
	/**
	 * Optionally called by the called of Input to trigger the first update
	 */
	public void commit();
	
	/**
	 * Mark this Input object as ready for use
	 * This must be called after all the parameters have been added
	 * and data members have been initialized
	 */
	public void ready();
	
	/**
	 * Return status symbol input for this symbol.
	 * Return exchange status symbol/heartbeat input for this symbol.
	 */
	public void statusInput();
	
	/**
	 * return the DispatcherTopic for update event
	 */
	public void updateTopic();
	
	/**
	 * Return a immutable and fully thread safe Snapshot object
	 * @return Snapshot of this input
	 */
	public Snapshot snapshot();
	 
}
