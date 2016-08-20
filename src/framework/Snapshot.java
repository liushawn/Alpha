package framework;

import java.sql.Timestamp;

import generic.data.ErrorCode;

/**
 * Snapshot is a immutable, thread-safe class which represent data returned from an Input.
 * Its data memebers are set once at the initialization. All the derived Snapshot should 
 * follow this pattern.
 * @author Shawn
 *
 */
public abstract class Snapshot {

	public Snapshot(String symbol, ErrorCode code, Timestamp timestamp){
		_symbol = symbol;
		_errorCode = code;
		_timestamp = timestamp;
	}
	
	/// Interface
	public abstract boolean equal(Snapshot another);

	/// Getter
	public String get_symbol() {
		return _symbol;
	}

	public ErrorCode get_errorCode() {
		return _errorCode;
	}

	public Timestamp get_timestamp() {
		return _timestamp;
	}

	private final String _symbol;
	
	private final ErrorCode _errorCode;
	
	private final Timestamp _timestamp;
}
