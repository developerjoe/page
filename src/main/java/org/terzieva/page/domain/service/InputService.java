package org.terzieva.page.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Header;
import org.springframework.stereotype.Service;
import org.terzieva.page.connection.InstanceFactory;

@Service
public class InputService {

	@Autowired
	private InstanceFactory factory;
	
	public void input(Message<byte[]> message, @Header("ip_connectionId") String connectionId)
	{
		String input = new String(message.getPayload());
		factory.getInstance(connectionId).interpret(input);
	}
	
}
