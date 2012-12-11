package org.terzieva.page.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.springframework.stereotype.Component;

@Component
public class InterpretationHandler implements ApplicationContextAware {
	
	private Map<String, Interpreter> interpreters;
	private ApplicationContext context;
	
	public InterpretationHandler()
	{
		interpreters = Collections.synchronizedMap(new HashMap<String,Interpreter>());
	}
	
	public void start(TcpConnection connection) {
		Interpreter interpreter = getInterpreter(connection);
		interpreter.start();
	}
	
	public void interpret(TcpConnection connection, String input)
	{
		Interpreter interpreter = getInterpreter(connection);
		
		// send the input to the interpreter
		interpreter.interpret(input);
		
		// if the interpreter should change the handler will switch it
		if(interpreter.interpreterShouldChange())
		{
			Interpreter newInterpreter = interpreter.getInterpreter();
			newInterpreter.setConnection(connection);
			interpreters.put(connection.getConnectionId(), newInterpreter);
			newInterpreter.start();
		}
	}
	
	private Interpreter getInterpreter(TcpConnection connection)
	{
		Interpreter interpreter = null;
		
		// set the interpreter if you have one
		if(interpreters.containsKey(connection.getConnectionId())) 
			interpreter = interpreters.get(connection.getConnectionId());
		
		// set up the default if not
		if(interpreter == null)
		{
			interpreter = context.getBean("startInterpreter",Interpreter.class);
			interpreter.setConnection(connection);
			interpreters.put(connection.getConnectionId(), interpreter);
		}
		
		return interpreter;
	}

	///////////////////////////////////////////////////////////////////
	// ApplicationContextAware
	///////////////////////////////////////////////////////////////////
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
	
}
