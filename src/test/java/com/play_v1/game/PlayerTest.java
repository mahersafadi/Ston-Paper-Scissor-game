package com.play_v1.game;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
	@Test
	public void testPlayerMethods(){
		Player player = new Player(1L, "TestPlayer");
		assertEquals(player.getId(), 1L);
		assertEquals(player.getName(), "TestPlayer");
	}
}
