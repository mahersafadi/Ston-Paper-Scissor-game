package com.play_v1.container.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.play_v1.container.PlayingService;
import com.play_v1.game.Game;
import com.play_v1.log.Log;

public class PlayingServiceImpl implements PlayingService {
	@Inject
	@Log
	private Logger logger;

	private Map<Long, Game> games = new ConcurrentHashMap<Long, Game>();

	public void addNewGame(Game game) {
		logger.info("Adding name game : " + game);
		if (game == null)
			throw new IllegalArgumentException("Game must not passed as null");
		this.games.put(game.getId(), game);
	}

	public boolean exist(Long gameId) {
		return games.containsKey(gameId);
	}

	public Game getGameById(Long id) {
		if (!exist(id))
			throw new java.lang.IllegalArgumentException("Game not exist");
		return games.get(id);
	}
	
	public void finishTheGame(Long gameId) {
		if(!exist(gameId))
			throw new IllegalArgumentException("Game to finish is not exist");
		this.games.remove(gameId);
	}

	public int getGamesNumber() {
		return this.games.size();
	}

}
