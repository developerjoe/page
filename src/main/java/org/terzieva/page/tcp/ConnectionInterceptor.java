package org.terzieva.page.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.serializer.Serializer;
import org.springframework.integration.ip.tcp.connection.AbstractTcpConnectionInterceptor;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.terzieva.page.connection.Instance;
import org.terzieva.page.connection.InstanceFactory;
import org.terzieva.page.domain.Player;

@Configurable
public class ConnectionInterceptor extends AbstractTcpConnectionInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionInterceptor.class);
	
	@Autowired private InstanceFactory factory;
	
	private Instance instance;
	
	@Override
	public void setSerializer(Serializer<?> serializer) {
		super.setSerializer(serializer);
		try {
			/* Sends a request to the instance's interpreter to determine
			 * the initial output when first connecting. */
			instance.start();
		} catch (Exception e) {
			logger.error("Could not send message for initial connection",e);
		}
	}
	
	@Override
	public void addNewConnection(TcpConnection connection) 
	{
		super.addNewConnection(connection);
		instance = factory.createInstance(connection);
	}
	
	@Override
	public void removeDeadConnection(TcpConnection connection) {
		factory.removeInstance(connection.getConnectionId());
		
		Player player = Player.findPlayersByConnectionIdEquals(connection.getConnectionId()).getSingleResult();
		player.setIsOnline(false);
		player = player.merge();
		
		super.removeDeadConnection(connection);
	}
	
}
