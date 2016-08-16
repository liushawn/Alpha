package framework.dispatcher;

import java.util.HashMap;
import java.util.Map;

public class DispatcherTopic {

	public DispatcherTopic(String name){
		topicName = name;
		subscriptions = new HashMap<String, DispatcherSubscription>();
	}
	
	public void updateNotify(){
		for(String subKey : subscriptions.keySet()){
			subscriptions.get(subKey).process(null);
		}
	}
	
	public void addSubscription(DispatcherSubscription subscription){
		
	}
	
	private String topicName;
	private Map<String, DispatcherSubscription> subscriptions;
}
