package org.terzieva.page.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.springframework.integration.message.GenericMessage;

public abstract class AbstractInterpreter implements Interpreter {
	
	public static final Logger logger = LoggerFactory.getLogger(AbstractInterpreter.class);
	
	protected String lastMessage;
	protected Interpreter interpreter;
	protected TcpConnection connection;
	
	@Override
	public void start() { }
	
	@Override
	public String getLastMessage() {
		return lastMessage;
	}

	@Override
	public Interpreter getInterpreter() {
		return interpreter;
	}

	@Override
	public boolean interpreterShouldChange() {
		return (interpreter != null) ? true : false;
	}

	@Override
	public void setConnection(TcpConnection connection) {
		this.connection = connection;
	}

	protected void send(String message)
	{
		try {
			connection.send(new GenericMessage<String>(message));
		} catch (Exception e) {
			// TODO: determine the best method for handling this error
			logger.error("Could not send message from interpreter",e);
		}
	}
	
}
