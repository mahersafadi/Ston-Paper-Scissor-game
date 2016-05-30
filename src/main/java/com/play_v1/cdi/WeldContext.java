package com.play_v1.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * This class is the responsible for dependency management which is Weld based.<br/>
 * 
 * <br/>
 * DreamIT
 * 
 * @author maher
 *
 */

public class WeldContext {
	public static final WeldContext INSTANCE = new WeldContext();

	private final Weld weld;
	private final WeldContainer container;

	private WeldContext() {
		this.weld = new Weld();
		this.container = weld.initialize();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				weld.shutdown();
			}
		});
	}

	/**
	 * To Get Any Bean in the class once use @Inject before it
	 * 
	 * @param type
	 * @return
	 */
	public <T> T getBean(Class<T> type) {
		return container.instance().select(type).get();
	}
}
