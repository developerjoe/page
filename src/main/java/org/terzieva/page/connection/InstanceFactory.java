package org.terzieva.page.connection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.terzieva.page.interpreter.LoginInterpreter;

/**
 * Stores and manages user instance data.
 * @author Joseph Terzieva
 *
 */
@Component
public class InstanceFactory {

	private Map<String,Instance> connections;
	
	public InstanceFactory()
	{
		connections = Collections.synchronizedMap(new HashMap<String,Instance>());
	}
	
	public Instance getInstance(String connectionId)
	{
		Instance instance = connections.get(connectionId);
		
		// return if not null
		if(instance != null) return instance; 
			
		// create if null
		instance = new Instance();
		connections.put(connectionId, instance);
		
		return instance;
	}
	
	public void removeInstance(String connectionId)
	{
		connections.remove(connectionId);
	}
	
}
