package generic.input;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import framework.Dispatcher;
import framework.Input;
import framework.Snapshot;
import framework.dispatcher.DispatcherTopic;
import generic.data.Security;

public class PulseInput implements Input, Runnable {

	public PulseInput(){
		_scheduler = Executors.newScheduledThreadPool(THREAD_NUM);
		_updateTopic = Dispatcher.getInstance().getDispatcherTopic("PULSE_INPUT");
		
	}
	
	@Override
	public void addParameter(String name, String value) {
		if( name.equals("INTERVAL") ){
			_interval = Long.parseLong(value);
		}else if( name.equals("INIT_DELAY") ){
			_initialDelay = Long.parseLong(value);
		}else if( name.equals("DURATION") ){
			_duration = Long.parseLong(value);
		}else{
			Logger.getLogger("INPUT").severe("UNsupported parameters for PulseInput: " + name);
		}
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ready() {
		 _scheduleHandler = _scheduler.scheduleAtFixedRate(this, 3, 3, TimeUnit.SECONDS);

		 if(_duration > 0){
			 _scheduler.schedule(new Runnable() {
				 public void run() { 
					 System.out.println("thread cxled");
					 _scheduleHandler.cancel(true); }
			 }, 
			 _duration,
			 TimeUnit.SECONDS);
		 }
	}

	@Override
	public void statusInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public DispatcherTopic updateTopic() {
		return _updateTopic;
	}

	@Override
	public Snapshot snapshot() {
		return null;
	}
	
	@Override
	public Security ticker(){
		return null;
	}
	
	/**
	 * callback function for PulseInput to update the DispatcherTopic subscriber
	 */
	@Override
	public void run() {
		System.out.println("run called inside PulseInput");
		Dispatcher.getInstance().publish(_updateTopic);
	}
	
	private long _interval;     // pulse event time interval
	
	private long _initialDelay; // first pulse event delay
	
	private long _duration;     // how long this pulse should last
	
	private DispatcherTopic _updateTopic;
	
	private ScheduledExecutorService _scheduler;
	
	private ScheduledFuture<?> _scheduleHandler;
	
	private final int THREAD_NUM = 1; 
	
	public static void main(String[] args){
		PulseInput in = new PulseInput();
		in.addParameter("INTERVAL", "3");
		in.addParameter("INIT_DELAY", "2");
		in.addParameter("DURATION", "30");
		in.ready();
		in.commit();

		System.out.println("finished");
	}



}
