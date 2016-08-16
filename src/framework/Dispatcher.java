package framework;

import framework.dispatcher.DispatcherSubscription;
import framework.dispatcher.DispatcherTopic;
import framework.dispatcher.DispatcherTopicStore;

public class Dispatcher {

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
	
	
	public DispatcherTopicStore getTopicStore() {
		return topicStore;
	}


	private DispatcherTopicStore topicStore;
}
