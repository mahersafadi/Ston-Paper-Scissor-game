package com.play_v1.container;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import com.play_v1.game.Choice;
import com.play_v1.game.Game;
import com.play_v1.game.Player;
import com.play_v1.game.Round;
import com.play_v1.game.impl.GameImpl;
import com.play_v1.tools.ChoiceEnum;
import com.play_v1.tools.GameIdGenerator;

public class TestPlayingServiceOver100ItemForSingleThread {
	@Rule
	public ConcurrentRule concurrently = new ConcurrentRule();

	@Rule
	public RepeatingRule repeatedly = new RepeatingRule();

	private static GameIdGenerator gameIdGenerator;

	private static Game game;
	private static Choice computerChoice;
	private static Random rand = new Random();
	private static int roundsResult = 0;

	@BeforeClass
	public static void prepare() {
		gameIdGenerator = new GameIdGenerator();
		game = new GameImpl(gameIdGenerator.getId());
		game.setFirstPlayer(new Player(1L, "AknowUser"));
		game.setSecondPlayer(new Player(2L, "TheComputer"));
		computerChoice = new Choice(ChoiceEnum.STONE);
	}

	@Test
	@Concurrent(count = 1)
	@Repeating(repetition = 100)
	public void testPlayingServiceOver100ItemForSingleThread() {
		Choice userChoice = new Choice(ChoiceEnum.fromInt(rand.nextInt(3) + 1));
		roundsResult += userChoice.compareTo(computerChoice);
		game.addRound(new Round(userChoice, computerChoice));
	}

	@AfterClass
	public static void displayTheResult() {
		if (game.isEqual()) {
			assertEquals(roundsResult, 0);
			System.out.println("equal");
		} else {
			System.out.println("There is a wninner");
			roundsResult = roundsResult > 0 ? roundsResult = 1 : -1;
			assertEquals(game.getWinner(), roundsResult);
		}
	}
}
