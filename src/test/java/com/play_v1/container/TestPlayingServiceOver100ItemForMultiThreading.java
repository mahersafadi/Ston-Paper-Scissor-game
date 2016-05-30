package com.play_v1.container;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import com.play_v1.cdi.WeldJUnit4Runner;
import com.play_v1.game.Choice;
import com.play_v1.game.Game;
import com.play_v1.game.Player;
import com.play_v1.game.Round;
import com.play_v1.log.Log;
import com.play_v1.tools.ChoiceEnum;

@RunWith(WeldJUnit4Runner.class)
public class TestPlayingServiceOver100ItemForMultiThreading {
	@Rule
	public ConcurrentRule concurrently = new ConcurrentRule();

	@Rule
	public RepeatingRule repeatedly = new RepeatingRule();

	@Inject
	private PlayingService playingService;

	@Inject
	private GameFactory gameFactory;

	@Inject
	@Log
	private Logger log;

	private static Random rand = new Random();

	@Test
	@Concurrent(count = 10)
	@Repeating(repetition = 1)
	public void testAddingMultiGamesAndPlayServiceMustHandleIt() {
		Game game = gameFactory.get();
		Player p1 = mock(Player.class);
		when(p1.getName()).thenReturn("User");
		when(p1.getId()).thenReturn(1L);
		Player p2 = mock(Player.class);
		when(p2.getName()).thenReturn("Computer");
		when(p2.getId()).thenReturn(2L);
		game.setFirstPlayer(p1);
		game.setSecondPlayer(p2);
		playingService.addNewGame(game);
		Choice userChoice = null;
		Long gameId = game.getId();
		Choice computerChoice = new Choice(ChoiceEnum.STONE);
		for (int i = 0; i < 100; i++) {
			userChoice = new Choice(ChoiceEnum.fromInt(rand.nextInt(3) + 1));
			game = playingService.getGameById(gameId);
			game.addRound(new Round(userChoice, computerChoice));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(playingService.getGamesNumber(), 10);
		assertEquals(playingService.getGameById(gameId).getRounds(), 100);
		log.info("Result:"
				+ (game.isEqual() ? "Equal " : game.getWinerPlayer()));
	}
}
