package com.play_v1.container;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.play_v1.cdi.WeldJUnit4Runner;
import com.play_v1.game.Game;
import com.play_v1.tools.GameIdGenerator;

@RunWith(WeldJUnit4Runner.class)
public class TestPlayingService {
	@Inject
	PlayingService playingService;

	@Inject
	private GameIdGenerator gameIdGenerator;

	@Test
	public void testAddGameToPlayingService() {
		Long id = gameIdGenerator.getId();
		Game game = mock(Game.class);
		when(game.getId()).thenReturn(id);
		when(game.toString()).thenReturn("Test Game for playing service");
		playingService.addNewGame(game);
		assertEquals(game.getId(), playingService.getGameById(id).getId());
	}

	@Test
	public void testFinishGameFromPlayingService() {
		Long id = gameIdGenerator.getId();
		Game game = mock(Game.class);
		when(game.getId()).thenReturn(id);
		when(game.toString()).thenReturn("Test Game for playing service");
		playingService.addNewGame(game);
		assertEquals(playingService.exist(game.getId()), true);
		playingService.finishTheGame(game.getId());
		assertEquals(playingService.exist(game.getId()), false);
	}
}
