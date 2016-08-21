package framework;

import framework.dispatcher.DispatcherSubscription;
import framework.dispatcher.DispatcherTopic;
import framework.dispatcher.DispatcherTopicStore;

public class Dispatcher {

	/**
	 * return the static object of Dispatcher
	 * @return initialized _singleton
	 */
	public static Dispatcher getInstance(){
		if(_singleton == null){
			_singleton = new Dispatcher();
		}
		return _singleton;
	}
	/**
	 * publish() notify all the subscribers to given topic that there is new data arrived.
	 * It doesn't support publish payload data directly yet. It's a TODO.
	 * 
	 * @param topic
	 */
	//TODO: support payload
	public void publish(DispatcherTopic topic){
		topic.updateNotify();		
	}
	
	/**
	 * subscribe() add the subscriber to the subscription list of given topic.
	 * It figures out the other attributes of a Subscription for the subscriber
	 * then create the DispatcherSubscription.
	 * 
	 * @param topic
	 * @param subscriber
	 */
	public void subscribe(DispatcherTopic topic, DispatcherSubscriber subscriber){
		DispatcherSubscription subscription = new DispatcherSubscription(subscriber); 
		topic.addSubscription(subscription);
	}
	
	
	/**
	 * return existing DispatcherTopic or create a new one if none in request exists
	 * @return DispatcherTopic
	 */
	public DispatcherTopic getDispatcherTopic(String topicName) {
		return _topicStore.createOrReturnTopic(topicName);
	}

	private Dispatcher(){
		_topicStore = new DispatcherTopicStore();
	}

	static private  Dispatcher _singleton; // private static data member to make sure this is class level singleton
	
	// class data member
	private DispatcherTopicStore _topicStore;
}
