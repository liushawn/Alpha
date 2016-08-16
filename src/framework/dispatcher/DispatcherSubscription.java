package framework.dispatcher;

import framework.DispatcherSubscriber;

public class DispatcherSubscription {
	
	public DispatcherSubscription(DispatcherSubscriber sub) {
		subscriptionPriority = 0;
		subscriber = sub;
	}
	
	public void process(Object o){
		subscriber.process(o);
	}
	
	private int subscriptionPriority;
	private DispatcherSubscriber subscriber;
}
