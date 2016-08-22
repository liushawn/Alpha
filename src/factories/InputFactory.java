package factories;

import java.util.HashMap;
import java.util.Map;

import framework.Alpha;
import framework.Input;
import generic.input.PulseInput;

/**
 * InputFactory generate the input instances based on the different registered input.
 * It is singleton and maintain the thread-safety.
 * 
 * 
 * This factory does 2 things:
 * a) create the input instance based on the type and symbol if it doesn't exist yet
 * b) store all the created inputs in the input store and return it if it exists already
 * @author Shawn
 *
 */
public class InputFactory {

	public static InputFactory getInstance()
	{
		return _singleton;
	}
	
	/**
	 * 
	 * @param inputType
	 * @param inputSymbol
	 * @return
	 */
	public Input createInput(String inputType, String inputSymbol){
		if(_inputStore.containsKey(inputSymbol)){
			return _inputStore.get(inputSymbol);
		}
		if(inputType == "Pulse"){
			Input input = new PulseInput();
			_inputStore.put(inputSymbol, input);
			return input;
		}else{
			//TODO add logging here for unsupported types
			return null;
		}
	}
	
	/**
	 * 
	 * @param alphaType
	 * @param alphaSymbol
	 * @return
	 */
	public Alpha createAlpha(String alphaType, String alphaSymbol){
		return null;
	}
	
	/**
	 * singleton pattern
	 */
	private InputFactory(){
		_inputStore = new HashMap<String, Input>();
	}
	
	
	private Map<String, Input> _inputStore;
	
	private static InputFactory _singleton = new InputFactory();
}
