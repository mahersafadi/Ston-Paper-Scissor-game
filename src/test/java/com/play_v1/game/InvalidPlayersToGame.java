package com.play_v1.game;

import org.junit.Test;

import com.play_v1.game.impl.GameImpl;

public class InvalidPlayersToGame {
	@Test(expected=IllegalArgumentException.class)
	public void testPassNullPlayer() {
		Game g = new GameImpl(1L);
		g.setFirstPlayer(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPassSamePlayerAsFirstAndSecond(){
		Player p = new Player(1L, "TestPlayer");
		Game g = new GameImpl(1L);
		g.setFirstPlayer(p);
		g.setSecondPlayer(p);
	}
}
