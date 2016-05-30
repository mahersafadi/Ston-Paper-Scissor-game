package com.play_v1.log;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingProducer produces the {@link Log} to be used in the application<br/>
 * 
 * DreamIT
 * 
 * @author maher
 *
 */
public class LoggingProducer {
	@Produces
	@Log
	private Logger createLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember()
				.getDeclaringClass());
	}
}
