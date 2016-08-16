package framework.dispatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is to hold all the topics created inside Dispatcher.
 * It should be a singleton. Just be held inside Dispatcher with one copy.
 * It manages the topic creation/deletion and guarantees the uniqueness of topic.
 * It's the factory and store of DispatcherTopic, which should never be created directly. 
 * @author Shawn
 *
 */
public class DispatcherTopicStore {

	public DispatcherTopicStore(){
		topicStore = new HashMap<String, DispatcherTopic>();
	}
	
	public DispatcherTopic createOrReturnTopic(String topicName){
		DispatcherTopic result;
		if(topicStore.containsKey(topicName)){
			result = topicStore.get(topicName);
		}else{
			result = new DispatcherTopic(topicName);
			topicStore.put(topicName, result);
		}
		return result;
	}
	
	public DispatcherTopic returnTopic(String topicName){
		return topicStore.get(topicName);
	}
	
	private Map<String, DispatcherTopic> topicStore;
}
