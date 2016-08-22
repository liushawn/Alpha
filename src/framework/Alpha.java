package framework;

import framework.dispatcher.DispatcherTopic;
import generic.data.ErrorCode;
import generic.data.Security;
import generic.enums.PublishPolicy;

/**
 * Alpha is the standard process unit for a well-specified purpose.
 * It's created by AlphaFactory. It listens to inputs and react to the updates from them.
 * It's also stream level object which is for particular security.
 * @author Shawn
 *
 */
public abstract class Alpha implements Input{

	@Override
	public void addParameter(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ready() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void statusInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DispatcherTopic updateTopic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Snapshot snapshot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Security ticker() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PublishPolicy publishPolicy(){
		return PublishPolicy.NOTIFICATION;
	}
	
	public AlphaSpec alphaSpec(){
		return new AlphaSpec();
	}

	/**
	 * handle configured parameters for this algorithm. It's called inside the addParameters().
	 * @param name
	 * @param value
	 */
	protected abstract void handleParameter(String name, String value);
	
	/**
	 * Prepare all the inputs/requisite based on the setting inside handleParameter().
	 * Called after handleParameter(). It typically does below:
	 * a) subscribe to certain inputs
	 * b) get reference data
	 * c) set the initial values for internal variables
	 */
	protected abstract void prepare();
	
	/**
	 * Validate all the setup for this algorithm to see if it's ready to process.
	 * Set the result in the errorcode.
	 * Called after prepare().
	 * 
	 * @param errorCode carrys the validate result
	 */
	protected abstract void validate(ErrorCode errorCode);
	
	/**
	 * Subscribe to the given input
	 * @param input: the input which this algorithm is going to subscribe to
	 */
	protected abstract void subscribe(Input input);
	
	/**
	 * Subscribe to the input until the internal status is "Known"
	 * @param input: the input which this algorithm is going to subscribe to
	 */
	protected abstract void subscribeUntilKnown();
	
	/**
	 * Calculate the new result for this algorithm based on the latest inputs.
	 * It's where the main logic resides. It's triggered by the events from the inputs.
	 * 
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	protected abstract Snapshot calculate(String name, String value);
	
	/**
	 * Get the input per input name from InputFactory with subscription or not
	 * @param name
	 * @param withSubscribe
	 * @return
	 */
	protected abstract Input getInput(String name, boolean withSubscribe);
}
