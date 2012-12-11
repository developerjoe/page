package org.terzieva.page.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.terzieva.page.interpreter.InterpretationHandler;

/**
 * Maintains information pertaining to a connected user's instance.
 * @author Joseph Terzieva
 *
 */
@Configurable
public class Instance {
	
	@Autowired InterpretationHandler handler;
	
	private TcpConnection connection;
	
	public Instance(TcpConnection connection)
	{
		this.connection = connection;
	}
	
	public void start()
	{
		handler.start(connection);
	}
	
	public void interpret(String input) {
		handler.interpret(connection,input);
	}
	
}
