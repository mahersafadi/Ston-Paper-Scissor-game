package com.play_v1;

import com.play_v1.cdi.WeldContext;

/**
 * This is the main entry of the application<br/>
 * <br/>
 * DreamIT
 * @author maher
 */
public class App {
	public static void main(String[] args) {
		WeldContext context = WeldContext.INSTANCE;
		StonePaperScissorGameDemo stonePaperScissorGame = context
				.getBean(StonePaperScissorGameDemo.class);
		stonePaperScissorGame.drisplayFinishedGameResult(stonePaperScissorGame
				.playDefaultGame());
	}
}
