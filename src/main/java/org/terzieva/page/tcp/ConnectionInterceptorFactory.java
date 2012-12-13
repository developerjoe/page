package org.terzieva.page.tcp;

import org.springframework.integration.ip.tcp.connection.TcpConnectionInterceptor;
import org.springframework.integration.ip.tcp.connection.TcpConnectionInterceptorFactory;

public class ConnectionInterceptorFactory implements TcpConnectionInterceptorFactory {

	@Override
	public TcpConnectionInterceptor getInterceptor() {
		return new ConnectionInterceptor();
	}

}
