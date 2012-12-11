package org.terzieva.page.interpreter;

import org.springframework.integration.ip.tcp.connection.TcpConnection;

public interface Interpreter {

	/**
	 * Notify the interpreter that it has been fully configured and should
	 * start. This can be used to send an initial message or begin processessing
	 * environmental data.
	 */
	public void start();
	
	/**
	 * Interpret parses the passed input and generates a new message.
	 * It may queue up a new interpreter.
	 * @param message
	 * @return
	 */
	public void interpret(String input);
	
	/**
	 * Gets the last message produced by the system.
	 * @return
	 */
	public String getLastMessage();
	
	/**
	 * Gets the interpreter. If nothing has changed this will reference
	 * the called object, otherwise it will be a reference to a new interpreter.
	 * @return
	 */
	public Interpreter getInterpreter();
	
	/**
	 * Notifies the requesting object if the interpreter should be changed or not.
	 */
	public boolean interpreterShouldChange();
	
	/**
	 * Adds a connection to the interpreter. This will be used to submit messages.
	 * @param connection
	 */
	public void setConnection(TcpConnection connection);
	
}
