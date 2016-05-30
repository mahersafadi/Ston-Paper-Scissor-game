package com.play_v1;

import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.play_v1.container.GameFactory;
import com.play_v1.container.PlayingService;
import com.play_v1.game.Choice;
import com.play_v1.game.Game;
import com.play_v1.game.Player;
import com.play_v1.game.Round;
import com.play_v1.log.Log;
import com.play_v1.tools.ChoiceEnum;

/**
 * This is a demo class to improve that the game is working, It contains a game
 * between user which choose a random choice and a computer which always choose
 * Stone choice. Because it is demo, no public methods, constructor are exist<br/>
 * 
 * DreamIT
 * 
 * @author maher
 *
 */
class StonePaperScissorGameDemo {
	@Inject
	private PlayingService playingService;

	@Inject
	private GameFactory gameFactory;

	@Inject
	@Log
	private Logger log;

	StonePaperScissorGameDemo() {

	}

	private long createGameAndPutItInPlayingService() {
		log.info("Preparing new Game");
		Game game = gameFactory.get();
		log.info("Game is created with id:" + game.getId());
		game.setFirstPlayer(new Player(1L, "The User"));
		game.setSecondPlayer(new Player(1L, "The Computer"));
		log.info("Game after adding players:" + game);
		playingService.addNewGame(game);
		log.info("Game with id: " + game.getId()
				+ " has been added to playing service");
		return game.getId();
	}

	long playDefaultGame() {
		long gameId = this.createGameAndPutItInPlayingService();
		log.info("Default Game has been strted");
		Choice computerChoice = new Choice(ChoiceEnum.STONE);
		Game game = playingService.getGameById(gameId);
		for (int i = 0; i < 100; i++) {
			game.addRound(new Round(getRandomChoice(), computerChoice));
		}
		log.info("Game " + gameId + " Has been finished");
		return gameId;
	}

	private Random rand = new Random();

	private Choice getRandomChoice() {
		return new Choice(ChoiceEnum.fromInt(rand.nextInt(3) + 1));
	}

	void drisplayFinishedGameResult(long gameId) {
		if (playingService.exist(gameId)) {
			Game game = playingService.getGameById(gameId);
			log.info(game.toString());
		} else {
			log.info("Game with Id:"
					+ gameId
					+ " is not exist into the playing service, so we can not display its result");
		}
	}
}
