package org.terzieva.page.connection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.springframework.stereotype.Component;

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
	
	public Instance createInstance(TcpConnection connection)
	{
		Instance instance = getInstance(connection.getConnectionId());
		
		if(instance != null) return instance;
		
		// create if null
		instance = new Instance(connection);
		connections.put(connection.getConnectionId(), instance);
		
		return instance;
	}
	
	public Instance getInstance(String connectionId)
	{
		Instance instance = connections.get(connectionId);
		return instance;
	}
	
	public void removeInstance(String connectionId)
	{
		connections.remove(connectionId);
	}
	
}
