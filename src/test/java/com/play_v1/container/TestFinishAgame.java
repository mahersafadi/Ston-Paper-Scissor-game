package com.play_v1.container;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.play_v1.cdi.WeldJUnit4Runner;
import com.play_v1.game.Game;
import static org.junit.Assert.*;

@RunWith(WeldJUnit4Runner.class)
public class TestFinishAgame {
	@Inject
	private PlayingService playingService;
	
	@Inject
	private GameFactory gameFactory;
	
	@Test
	public void checkFinishAGame(){
		Game game = gameFactory.get();
		playingService.addNewGame(game);
		assertEquals(true, playingService.exist(game.getId()));
		playingService.finishTheGame(game.getId());
		assertEquals(false, playingService.exist(game.getId()));
	}
}
